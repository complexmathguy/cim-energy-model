import React, { Component } from 'react'
import WindDynamicsLookupTableService from '../services/WindDynamicsLookupTableService';

class CreateWindDynamicsLookupTableComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                input: '',
                lookupTableFunctionType: '',
                output: '',
                sequence: ''
        }
        this.changeinputHandler = this.changeinputHandler.bind(this);
        this.changelookupTableFunctionTypeHandler = this.changelookupTableFunctionTypeHandler.bind(this);
        this.changeoutputHandler = this.changeoutputHandler.bind(this);
        this.changesequenceHandler = this.changesequenceHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            WindDynamicsLookupTableService.getWindDynamicsLookupTableById(this.state.id).then( (res) =>{
                let windDynamicsLookupTable = res.data;
                this.setState({
                    input: windDynamicsLookupTable.input,
                    lookupTableFunctionType: windDynamicsLookupTable.lookupTableFunctionType,
                    output: windDynamicsLookupTable.output,
                    sequence: windDynamicsLookupTable.sequence
                });
            });
        }        
    }
    saveOrUpdateWindDynamicsLookupTable = (e) => {
        e.preventDefault();
        let windDynamicsLookupTable = {
                windDynamicsLookupTableId: this.state.id,
                input: this.state.input,
                lookupTableFunctionType: this.state.lookupTableFunctionType,
                output: this.state.output,
                sequence: this.state.sequence
            };
        console.log('windDynamicsLookupTable => ' + JSON.stringify(windDynamicsLookupTable));

        // step 5
        if(this.state.id === '_add'){
            windDynamicsLookupTable.windDynamicsLookupTableId=''
            WindDynamicsLookupTableService.createWindDynamicsLookupTable(windDynamicsLookupTable).then(res =>{
                this.props.history.push('/windDynamicsLookupTables');
            });
        }else{
            WindDynamicsLookupTableService.updateWindDynamicsLookupTable(windDynamicsLookupTable).then( res => {
                this.props.history.push('/windDynamicsLookupTables');
            });
        }
    }
    
    changeinputHandler= (event) => {
        this.setState({input: event.target.value});
    }
    changelookupTableFunctionTypeHandler= (event) => {
        this.setState({lookupTableFunctionType: event.target.value});
    }
    changeoutputHandler= (event) => {
        this.setState({output: event.target.value});
    }
    changesequenceHandler= (event) => {
        this.setState({sequence: event.target.value});
    }

    cancel(){
        this.props.history.push('/windDynamicsLookupTables');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindDynamicsLookupTable</h3>
        }else{
            return <h3 className="text-center">Update WindDynamicsLookupTable</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> input: </label>
                                            #formFields( $attribute, 'create')
                                            <label> lookupTableFunctionType: </label>
                                            #formFields( $attribute, 'create')
                                            <label> output: </label>
                                            #formFields( $attribute, 'create')
                                            <label> sequence: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindDynamicsLookupTable}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                   </div>
            </div>
        )
    }
}

export default CreateWindDynamicsLookupTableComponent
