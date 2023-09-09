<template>
    <div>
        <BasePicker v-if="editMode" searchApiPath="projectmasters" searchParameterName="projectId"  idField="projectId" nameField="projectId" path="projectmasters" label="ProjectMasterId" v-model="value" @selected="pick" :editMode="editMode" />
        <div v-else style="height:100%">
            <span>{{ value && value.name ? value.name : '' }}</span>
        </div>
    </div>

</template>

<script>
import BaseEntity from './base-ui/BaseEntity'

export default {
    name: 'ProjectMasterId',
    mixins:[BaseEntity],
    components:{
    },
    data: () => ({
        path: 'projectmasters',
    }),
    props: {
    },
    watch: {
        value(val){
            this.value = val;
            this.change();
        },
    },
    async created(){
        if (this.value && this.value.id !== undefined) {
            this.value = await this.repository.findById(this.value.id)
        }
    },
    methods: {
        pick(val){
            this.value = val;
            this.change();
        },
    }
}
</script>

