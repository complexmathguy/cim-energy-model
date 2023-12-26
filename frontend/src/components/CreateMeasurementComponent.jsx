import React, { Component } from 'react'
import MeasurementService from '../services/MeasurementService';

class CreateMeasurementComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                measurementType: '',
                phases: '',
                unitMultiplier: '',
                unitSymbol: ''
        }
        this.changemeasurementTypeHandler = this.changemeasurementTypeHandler.bind(this);
        this.changephasesHandler = this.changephasesHandler.bind(this);
        this.changeunitMultiplierHandler = this.changeunitMultiplierHandler.bind(this);
        this.changeunitSymbolHandler = this.changeunitSymbolHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            MeasurementService.getMeasurementById(this.state.id).then( (res) =>{
                let measurement = res.data;
                this.setState({
                    measurementType: measurement.measurementType,
                    phases: measurement.phases,
                    unitMultiplier: measurement.unitMultiplier,
                    unitSymbol: measurement.unitSymbol
                });
            });
        }        
    }
    saveOrUpdateMeasurement = (e) => {
        e.preventDefault();
        let measurement = {
                measurementId: this.state.id,
                measurementType: this.state.measurementType,
                phases: this.state.phases,
                unitMultiplier: this.state.unitMultiplier,
                unitSymbol: this.state.unitSymbol
            };
        console.log('measurement => ' + JSON.stringify(measurement));

        // step 5
        if(this.state.id === '_add'){
            measurement.measurementId=''
            MeasurementService.createMeasurement(measurement).then(res =>{
                this.props.history.push('/measurements');
            });
        }else{
            MeasurementService.updateMeasurement(measurement).then( res => {
                this.props.history.push('/measurements');
            });
        }
    }
    
    changemeasurementTypeHandler= (event) => {
        this.setState({measurementType: event.target.value});
    }
    changephasesHandler= (event) => {
        this.setState({phases: event.target.value});
    }
    changeunitMultiplierHandler= (event) => {
        this.setState({unitMultiplier: event.target.value});
    }
    changeunitSymbolHandler= (event) => {
        this.setState({unitSymbol: event.target.value});
    }

    cancel(){
        this.props.history.push('/measurements');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Measurement</h3>
        }else{
            return <h3 className="text-center">Update Measurement</h3>
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
                                            <label> measurementType: </label>
                                            #formFields( $attribute, 'create')
                                            <label> phases: </label>
                                            #formFields( $attribute, 'create')
                                            <label> unitMultiplier: </label>
                                            #formFields( $attribute, 'create')
                                            <label> unitSymbol: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateMeasurement}>Save</button>
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

export default CreateMeasurementComponent
