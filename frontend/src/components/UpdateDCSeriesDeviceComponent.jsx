import React, { Component } from 'react'
import DCSeriesDeviceService from '../services/DCSeriesDeviceService';

class UpdateDCSeriesDeviceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                inductance: '',
                ratedUdc: '',
                resistance: ''
        }
        this.updateDCSeriesDevice = this.updateDCSeriesDevice.bind(this);

        this.changeinductanceHandler = this.changeinductanceHandler.bind(this);
        this.changeratedUdcHandler = this.changeratedUdcHandler.bind(this);
        this.changeresistanceHandler = this.changeresistanceHandler.bind(this);
    }

    componentDidMount(){
        DCSeriesDeviceService.getDCSeriesDeviceById(this.state.id).then( (res) =>{
            let dCSeriesDevice = res.data;
            this.setState({
                inductance: dCSeriesDevice.inductance,
                ratedUdc: dCSeriesDevice.ratedUdc,
                resistance: dCSeriesDevice.resistance
            });
        });
    }

    updateDCSeriesDevice = (e) => {
        e.preventDefault();
        let dCSeriesDevice = {
            dCSeriesDeviceId: this.state.id,
            inductance: this.state.inductance,
            ratedUdc: this.state.ratedUdc,
            resistance: this.state.resistance
        };
        console.log('dCSeriesDevice => ' + JSON.stringify(dCSeriesDevice));
        console.log('id => ' + JSON.stringify(this.state.id));
        DCSeriesDeviceService.updateDCSeriesDevice(dCSeriesDevice).then( res => {
            this.props.history.push('/dCSeriesDevices');
        });
    }

    changeinductanceHandler= (event) => {
        this.setState({inductance: event.target.value});
    }
    changeratedUdcHandler= (event) => {
        this.setState({ratedUdc: event.target.value});
    }
    changeresistanceHandler= (event) => {
        this.setState({resistance: event.target.value});
    }

    cancel(){
        this.props.history.push('/dCSeriesDevices');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DCSeriesDevice</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> inductance: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ratedUdc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> resistance: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDCSeriesDevice}>Save</button>
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

export default UpdateDCSeriesDeviceComponent
