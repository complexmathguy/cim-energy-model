import React, { Component } from 'react'
import WindDynamicsLookupTableService from '../services/WindDynamicsLookupTableService';

class UpdateWindDynamicsLookupTableComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                input: '',
                lookupTableFunctionType: '',
                output: '',
                sequence: ''
        }
        this.updateWindDynamicsLookupTable = this.updateWindDynamicsLookupTable.bind(this);

        this.changeinputHandler = this.changeinputHandler.bind(this);
        this.changelookupTableFunctionTypeHandler = this.changelookupTableFunctionTypeHandler.bind(this);
        this.changeoutputHandler = this.changeoutputHandler.bind(this);
        this.changesequenceHandler = this.changesequenceHandler.bind(this);
    }

    componentDidMount(){
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

    updateWindDynamicsLookupTable = (e) => {
        e.preventDefault();
        let windDynamicsLookupTable = {
            windDynamicsLookupTableId: this.state.id,
            input: this.state.input,
            lookupTableFunctionType: this.state.lookupTableFunctionType,
            output: this.state.output,
            sequence: this.state.sequence
        };
        console.log('windDynamicsLookupTable => ' + JSON.stringify(windDynamicsLookupTable));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindDynamicsLookupTableService.updateWindDynamicsLookupTable(windDynamicsLookupTable).then( res => {
            this.props.history.push('/windDynamicsLookupTables');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindDynamicsLookupTable</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> input: </label>
                                            #formFields( $attribute, 'update')
                                            <label> lookupTableFunctionType: </label>
                                            #formFields( $attribute, 'update')
                                            <label> output: </label>
                                            #formFields( $attribute, 'update')
                                            <label> sequence: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindDynamicsLookupTable}>Save</button>
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

export default UpdateWindDynamicsLookupTableComponent
