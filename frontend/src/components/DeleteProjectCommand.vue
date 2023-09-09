<template>
    <v-card outlined>
        <v-card-title>
            DeleteProject
        </v-card-title>

        <v-card-text>
            <String label="NoticeProjectName" v-model="value.noticeProjectName" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="deleteProject"
            >
                DeleteProject
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'DeleteProjectCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.noticeProjectName = '';
        },
        watch: {
        },
        methods: {
            deleteProject() {
                this.$emit('deleteProject', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

