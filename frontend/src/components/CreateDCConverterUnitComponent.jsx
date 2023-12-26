import React, { Component } from 'react'
import DCConverterUnitService from '../services/DCConverterUnitService';

class CreateDCConverterUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                operationMode: ''
        }
        this.changeoperationModeHandler = this.changeoperationModeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            DCConverterUnitService.getDCConverterUnitById(this.state.id).then( (res) =>{
                let dCConverterUnit = res.data;
                this.setState({
                    operationMode: dCConverterUnit.operationMode
                });
            });
        }        
    }
    saveOrUpdateDCConverterUnit = (e) => {
        e.preventDefault();
        let dCConverterUnit = {
                dCConverterUnitId: this.state.id,
                operationMode: this.state.operationMode
            };
        console.log('dCConverterUnit => ' + JSON.stringify(dCConverterUnit));

        // step 5
        if(this.state.id === '_add'){
            dCConverterUnit.dCConverterUnitId=''
            DCConverterUnitService.createDCConverterUnit(dCConverterUnit).then(res =>{
                this.props.history.push('/dCConverterUnits');
            });
        }else{
            DCConverterUnitService.updateDCConverterUnit(dCConverterUnit).then( res => {
                this.props.history.push('/dCConverterUnits');
            });
        }
    }
    
    changeoperationModeHandler= (event) => {
        this.setState({operationMode: event.target.value});
    }

    cancel(){
        this.props.history.push('/dCConverterUnits');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DCConverterUnit</h3>
        }else{
            return <h3 className="text-center">Update DCConverterUnit</h3>
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
                                            <label> operationMode: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDCConverterUnit}>Save</button>
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

export default CreateDCConverterUnitComponent
