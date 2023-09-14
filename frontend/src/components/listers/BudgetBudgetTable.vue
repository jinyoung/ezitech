<template>
    <div>
        <v-data-table
                :headers="headers"
                :items="values"
                :items-per-page="5"
                class="elevation-1"
        ></v-data-table>

        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                        v-model="openDialog"
                        width="332.5"
                        fullscreen
                        hide-overlay
                        transition="dialog-bottom-transition"
                >
                    <template v-slot:activator="{ on, attrs }">
                        <v-fab-transition>
                            <v-btn
                                    color="primary"
                                    fab
                                    dark
                                    large
                                    style="position:absolute; bottom: 5%; right: 2%; z-index:99"
                                    @click="openDialog=true;"
                            >
                                <v-icon v-bind="attrs" v-on="on">mdi-plus</v-icon>
                            </v-btn>
                        </v-fab-transition>
                    </template>

                    <BudgetBudget :offline="offline" class="video-card" :isNew="true" :editMode="true" v-model="newValue" @add="append" v-if="tick"/>
                
                    <v-btn
                            style="postition:absolute; top:2%; right:2%"
                            @click="closeDialog()"
                            depressed 
                            icon 
                            absolute
                    >
                        <v-icon>mdi-close</v-icon>
                    </v-btn>
                </v-dialog>
            </div>
        </v-col>
    </div>
</template>

<script>
    const axios = require('axios').default;
    import BudgetBudget from './../BudgetBudget.vue';

    export default {
        name: 'BudgetBudgetManager',
        components: {
            BudgetBudget,
        },
        props: {
            offline: Boolean,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            values: [],
            headers: 
                [
                    { text: "issueManagementNumber", value: "issueManagementNumber" },
                    { text: "privateBurdenRate", value: "privateBurdenRate" },
                    { text: "privateCashBurdenRate", value: "privateCashBurdenRate" },
                    { text: "studentResearchExpenses", value: "studentResearchExpenses" },
                    { text: "internalPersonnelExpenses", value: "internalPersonnelExpenses" },
                    { text: "externalPersonnelExpenses", value: "externalPersonnelExpenses" },
                    { text: "studentResearchExpenses", value: "studentResearchExpenses" },
                    { text: "materialExpenses", value: "materialExpenses" },
                    { text: "researchFacilityExpenses", value: "researchFacilityExpenses" },
                    { text: "activityExpenses", value: "activityExpenses" },
                    { text: "projectMasterId", value: "projectMasterId" },
                    { text: "governmentSupportFunds", value: "governmentSupportFunds" },
                    { text: "personnelExpenses", value: "personnelExpenses" },
                ],
            budget : [],
            newValue: {},
            tick : true,
            openDialog : false,
        }),
        async created() {
            if(this.offline){
                if(!this.values) this.values = [];
                return;
            }

            var temp = await axios.get(axios.fixUrl('/budgets'))
            temp.data._embedded.budgets.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])
            this.values = temp.data._embedded.budgets;

            this.newValue = {
                'issueManagementNumber': '',
                'privateBurdenRate': 0,
                'privateCashBurdenRate': 0,
                'studentResearchExpenses': {},
                'internalPersonnelExpenses': {},
                'externalPersonnelExpenses': {},
                'studentResearchExpenses': {},
                'materialExpenses': '',
                'researchFacilityExpenses': '',
                'activityExpenses': '',
                'projectMasterId': {},
                'governmentSupportFunds': {},
                'personnelExpenses': {},
            }
        },
        methods: {
            closeDialog(){
                this.openDialog = false
            },
            append(value){
                this.tick = false
                this.newValue = {}
                this.values.push(value)
                
                this.$emit('input', this.values);

                this.$nextTick(function(){
                    this.tick=true
                })
            },
        }
    }
</script>

