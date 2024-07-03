<template>
    <div class="banner">
        <div class="banner-prev" @click="prev"></div>
        <div class="banner-next" @click="next"></div>
        <transition-group tag="ul" name="banner-trans" class="banner-container">
            <li
                class="image-container"
                v-for="(item, index) in banners"
                v-show="index === imgIndex"
                :key="index"
            >
                <a :href="item.url" target="_blank">
                    <img :src="item.src" />
                </a>
            </li>
        </transition-group>
        <div class="banner-points">
            <a
                class="banner-point"
                @click="jump(index)"
                :class="{ active: index === imgIndex }"
                v-for="(item, index) in banners.length"
                :key="index"
            ></a>
        </div>
    </div>
</template>

<script lang='ts' setup>
import {ref, onMounted, onUnmounted} from 'vue'

interface Banner{
    src: string
    alt: string
}

const imgIndex = ref(0)
let timer: number | undefined

const props = defineProps<{banners: Banner[]}>();

const next = () =>{
    const lastPage = props.banners.length - 1;
    imgIndex.value = imgIndex.value < lastPage ? imgIndex.value + 1 : 0
}

const prev = () => {
    const lastPage = props.banners.length - 1
    imgIndex.value = imgIndex.value > 0 ? imgIndex.value - 1 : lastPage
}

const play = () => {
    clearInterval(timer)
    timer = window.setInterval(next, 5000)
}

const jump = (index: number) => {
    imgIndex.value = index
}

onMounted(() => {
    play()
})
</script>



<style lang="less">
.banner {
    position: relative;
    .banner-prev {
        position: absolute;
        top: 50%;
        width: 41px;
        height: 69px;
        margin-top: -35px;
        z-index: 5;
        cursor: pointer;
        outline: none;
        background: url(../../assets/image/icon-slides.png) no-repeat -84px 50%;
        left: 234px;
        right: auto;
        &:hover {
            background: url(../../assets/image/icon-slides.png) no-repeat 0px
                50%;
        }
    }

    .banner-next {
        position: absolute;
        top: 50%;
        width: 41px;
        height: 69px;
        margin-top: -35px;
        z-index: 5;
        cursor: pointer;
        outline: none;
        background: url(../../assets/image/icon-slides.png) no-repeat -125px 50%;
        right: 0;
        left: auto;
        &:hover {
            background: url(../../assets/image/icon-slides.png) no-repeat -43px 50%;
        }
    }

    .banner-points {
        position: absolute;
        display: inline-block;
        width: 400px;
        left: auto;
        right: 30px;
        bottom: 20px;
        text-align: right;
        transform: translateZ(0);
        z-index: 10;
        .banner-point {
            display: inline-block;
            width: 10px;
            height: 10px;
            border: 2px solid #fff;
            border-color: hsla(0, 0%, 100%, 0.3);
            border-radius: 10px;
            overflow: hidden;
            background: rgba(0, 0, 0, 0.4);
            opacity: 1;
            margin: 0 4px;
            cursor: pointer;
            &:hover {
                background: hsla(0, 0%, 100%, 0.4);
                border-color: rgba(0, 0, 0, 0.4);
            }
        }

        .active {
            background: hsla(0, 0%, 100%, 0.4);
            border-color: rgba(0, 0, 0, 0.4);
        }
    }

    .banner-container {
        width: 100%;
        height: 460px;
        overflow: hidden;
        .image-container {
            width: 100%;
            height: 100%;
            a {
                display: block;
                width: 100%;
                height: 100%;
                img {
                    width: 100%;
                }
            }
        }
    }
}

// 轮播图
.banner-trans-enter-active {
    transition: all 0.1s ease-in-out;
    opacity: 1;
}

.banner-trans-leave-active {
    opacity: 0;
}

.banner-trans-enter,
.banner-trans-leave-to {
    opacity: 0;
}

.banner-trans-enter-to,
.banner-trans-leave {
    opacity: 1;
}
</style>