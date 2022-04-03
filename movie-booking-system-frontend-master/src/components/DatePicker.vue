<template>
    <date-pick
        v-model="date"
        :format="'YYYY.MM.DD'"
    ></date-pick>
</template>

<script>
import DatePick from 'vue-date-pick';
export default {
    components: {DatePick},
    data: () => ({
        date: '2019.01.01'
    })
};
</script>