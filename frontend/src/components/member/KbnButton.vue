<template>
    <button
        :class = 'classed'
        :disable = 'disabled'
        type = 'button'
        @click = 'handleClick'
    >
    <slot />
    </button>    
</template>
<script>
export default {
    name: 'KbnButton',

    props: {
        //부모 컴포넌트에서 자식 컴포넌트로 정보 전달.
        type: {
            type: String,
            default: 'button'
        },
        disabled: {
            type: Boolean,
            default: false
        }
    },

    computed: {
        // 'type' 값에 따라 동적으로 클래스를 생성
        classes () {
            const cls = this.type === 'text' ? ('-'+ this.type) : ''
            return ['kbn-button${cls}']
        }
    },

    methods: {
        //'click' 이벤트 발생
        handleClick(ev){
            this.$emit('click', ev)
        }
    }
}
</script>
<style scoped>

</style>
