import React, { Component } from 'react'
import SolarGeneratingUnitService from '../services/SolarGeneratingUnitService';

class UpdateSolarGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateSolarGeneratingUnit = this.updateSolarGeneratingUnit.bind(this);

    }

    componentDidMount(){
        SolarGeneratingUnitService.getSolarGeneratingUnitById(this.state.id).then( (res) =>{
            let solarGeneratingUnit = res.data;
            this.setState({
            });
        });
    }

    updateSolarGeneratingUnit = (e) => {
        e.preventDefault();
        let solarGeneratingUnit = {
            solarGeneratingUnitId: this.state.id,
        };
        console.log('solarGeneratingUnit => ' + JSON.stringify(solarGeneratingUnit));
        console.log('id => ' + JSON.stringify(this.state.id));
        SolarGeneratingUnitService.updateSolarGeneratingUnit(solarGeneratingUnit).then( res => {
            this.props.history.push('/solarGeneratingUnits');
        });
    }


    cancel(){
        this.props.history.push('/solarGeneratingUnits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SolarGeneratingUnit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSolarGeneratingUnit}>Save</button>
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

export default UpdateSolarGeneratingUnitComponent
