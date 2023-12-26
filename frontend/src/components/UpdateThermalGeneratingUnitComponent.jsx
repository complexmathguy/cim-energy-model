import React, { Component } from 'react'
import ThermalGeneratingUnitService from '../services/ThermalGeneratingUnitService';

class UpdateThermalGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateThermalGeneratingUnit = this.updateThermalGeneratingUnit.bind(this);

    }

    componentDidMount(){
        ThermalGeneratingUnitService.getThermalGeneratingUnitById(this.state.id).then( (res) =>{
            let thermalGeneratingUnit = res.data;
            this.setState({
            });
        });
    }

    updateThermalGeneratingUnit = (e) => {
        e.preventDefault();
        let thermalGeneratingUnit = {
            thermalGeneratingUnitId: this.state.id,
        };
        console.log('thermalGeneratingUnit => ' + JSON.stringify(thermalGeneratingUnit));
        console.log('id => ' + JSON.stringify(this.state.id));
        ThermalGeneratingUnitService.updateThermalGeneratingUnit(thermalGeneratingUnit).then( res => {
            this.props.history.push('/thermalGeneratingUnits');
        });
    }


    cancel(){
        this.props.history.push('/thermalGeneratingUnits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ThermalGeneratingUnit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateThermalGeneratingUnit}>Save</button>
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

export default UpdateThermalGeneratingUnitComponent
