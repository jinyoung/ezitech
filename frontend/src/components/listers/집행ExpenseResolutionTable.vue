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

                    <집행ExpenseResolution :offline="offline" class="video-card" :isNew="true" :editMode="true" v-model="newValue" @add="append" v-if="tick"/>
                
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
    import 집행ExpenseResolution from './../집행ExpenseResolution.vue';

    export default {
        name: '집행ExpenseResolutionManager',
        components: {
            집행ExpenseResolution,
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
                    { text: "resolutionNumber", value: "resolutionNumber" },
                    { text: "directOrIndirectExpense", value: "directOrIndirectExpense" },
                    { text: "item", value: "item" },
                    { text: "resolutionName", value: "resolutionName" },
                    { text: "totalAmount", value: "totalAmount" },
                    { text: "vendorName", value: "vendorName" },
                    { text: "bankName", value: "bankName" },
                    { text: "bankAccountNumber", value: "bankAccountNumber" },
                    { text: "accountOwner", value: "accountOwner" },
                    { text: "resolutionContent", value: "resolutionContent" },
                    { text: "attachments", value: "attachments" },
                    { text: "approvalStatus", value: "approvalStatus" },
                    { text: "approvalLine", value: "approvalLine" },
                ],
            expenseResolution : [],
            newValue: {},
            tick : true,
            openDialog : false,
        }),
        async created() {
            if(this.offline){
                if(!this.values) this.values = [];
                return;
            }

            var temp = await axios.get(axios.fixUrl('/expenseresolutions'))
            temp.data._embedded.expenseresolutions.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])
            this.values = temp.data._embedded.expenseresolutions;

            this.newValue = {
                'resolutionNumber': '',
                'directOrIndirectExpense': '',
                'item': '',
                'resolutionName': '',
                'totalAmount': '',
                'vendorName': '',
                'bankName': '',
                'bankAccountNumber': '',
                'accountOwner': '',
                'resolutionContent': '',
                'attachments': [],
                'approvalStatus': '',
                'approvalLine': '',
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

