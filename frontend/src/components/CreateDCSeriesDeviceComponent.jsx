import React, { Component } from 'react'
import DCSeriesDeviceService from '../services/DCSeriesDeviceService';

class CreateDCSeriesDeviceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                inductance: '',
                ratedUdc: '',
                resistance: ''
        }
        this.changeinductanceHandler = this.changeinductanceHandler.bind(this);
        this.changeratedUdcHandler = this.changeratedUdcHandler.bind(this);
        this.changeresistanceHandler = this.changeresistanceHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            DCSeriesDeviceService.getDCSeriesDeviceById(this.state.id).then( (res) =>{
                let dCSeriesDevice = res.data;
                this.setState({
                    inductance: dCSeriesDevice.inductance,
                    ratedUdc: dCSeriesDevice.ratedUdc,
                    resistance: dCSeriesDevice.resistance
                });
            });
        }        
    }
    saveOrUpdateDCSeriesDevice = (e) => {
        e.preventDefault();
        let dCSeriesDevice = {
                dCSeriesDeviceId: this.state.id,
                inductance: this.state.inductance,
                ratedUdc: this.state.ratedUdc,
                resistance: this.state.resistance
            };
        console.log('dCSeriesDevice => ' + JSON.stringify(dCSeriesDevice));

        // step 5
        if(this.state.id === '_add'){
            dCSeriesDevice.dCSeriesDeviceId=''
            DCSeriesDeviceService.createDCSeriesDevice(dCSeriesDevice).then(res =>{
                this.props.history.push('/dCSeriesDevices');
            });
        }else{
            DCSeriesDeviceService.updateDCSeriesDevice(dCSeriesDevice).then( res => {
                this.props.history.push('/dCSeriesDevices');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DCSeriesDevice</h3>
        }else{
            return <h3 className="text-center">Update DCSeriesDevice</h3>
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
                                            <label> inductance: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ratedUdc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> resistance: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDCSeriesDevice}>Save</button>
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

export default CreateDCSeriesDeviceComponent
