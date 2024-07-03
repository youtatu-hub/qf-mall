<template>
    <div class="index-page">
        <MenuBanner />
        <div class="gray-page">
            <GoodSale />
        </div>
    </div>
</template>

<script lang='ts' setup>
import MenuBanner from "../components/index/MenuBanner.vue";
import GoodsSale from "../components/index/GoodsSale.vue";

</script>

<style lang="less">
.index-page {
    .gray-page {
        display: flex;
        flex-direction: column;
        width: 100%;
        height: auto;
        background-color: #f5f5f5;
    }
}
</style>