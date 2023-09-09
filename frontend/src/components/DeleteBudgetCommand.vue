<template>
    <v-card outlined>
        <v-card-title>
            DeleteBudget
        </v-card-title>

        <v-card-text>
            <String label="TaskManagementNumber" v-model="value.taskManagementNumber" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="deleteBudget"
            >
                DeleteBudget
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
        name: 'DeleteBudgetCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.taskManagementNumber = '';
        },
        watch: {
        },
        methods: {
            deleteBudget() {
                this.$emit('deleteBudget', this.value);
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

