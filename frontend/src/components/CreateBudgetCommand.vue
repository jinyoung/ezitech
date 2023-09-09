<template>
    <v-card outlined>
        <v-card-title>
            CreateBudget
        </v-card-title>

        <v-card-text>
            <String label="TaskManagementNumber" v-model="value.taskManagementNumber" :editMode="editMode"/>
            <Money offline label="GovernmentSupportAmount" v-model="value.governmentSupportAmount" :editMode="editMode" @change="change"/>
            <Number label="PrivateRatio" v-model="value.privateRatio" :editMode="editMode"/>
            <Number label="PrivateCashRatio" v-model="value.privateCashRatio" :editMode="editMode"/>
            <Money offline label="LaborCost" v-model="value.laborCost" :editMode="editMode" @change="change"/>
            <Money offline label="InternalLaborCost" v-model="value.internalLaborCost" :editMode="editMode" @change="change"/>
            <Money offline label="ExternalLaborCost" v-model="value.externalLaborCost" :editMode="editMode" @change="change"/>
            <Money offline label="StudentResearchCost" v-model="value.studentResearchCost" :editMode="editMode" @change="change"/>
            <MaterialCost offline label="MaterialCost" v-model="value.materialCost" :editMode="editMode" @change="change"/>
            <ResearchFacilityCost offline label="ResearchFacilityCost" v-model="value.researchFacilityCost" :editMode="editMode" @change="change"/>
            <ActivityCost offline label="ActivityCost" v-model="value.activityCost" :editMode="editMode" @change="change"/>
            <IndirectCost offline label="IndirectCost" v-model="value.indirectCost" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createBudget"
            >
                CreateBudget
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
        name: 'CreateBudgetCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.taskManagementNumber = '';
            this.value.governmentSupportAmount = {};
            this.value.privateRatio = 0;
            this.value.privateCashRatio = 0;
            this.value.laborCost = {};
            this.value.internalLaborCost = {};
            this.value.externalLaborCost = {};
            this.value.studentResearchCost = {};
            this.value.materialCost = {};
            this.value.researchFacilityCost = {};
            this.value.activityCost = {};
            this.value.indirectCost = {};
        },
        watch: {
        },
        methods: {
            createBudget() {
                this.$emit('createBudget', this.value);
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

