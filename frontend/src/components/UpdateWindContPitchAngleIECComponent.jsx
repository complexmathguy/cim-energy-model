import React, { Component } from 'react'
import WindContPitchAngleIECService from '../services/WindContPitchAngleIECService';

class UpdateWindContPitchAngleIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                dthetamax: '',
                dthetamin: '',
                kic: '',
                kiomega: '',
                kpc: '',
                kpomega: '',
                kpx: '',
                thetamax: '',
                thetamin: '',
                ttheta: ''
        }
        this.updateWindContPitchAngleIEC = this.updateWindContPitchAngleIEC.bind(this);

        this.changedthetamaxHandler = this.changedthetamaxHandler.bind(this);
        this.changedthetaminHandler = this.changedthetaminHandler.bind(this);
        this.changekicHandler = this.changekicHandler.bind(this);
        this.changekiomegaHandler = this.changekiomegaHandler.bind(this);
        this.changekpcHandler = this.changekpcHandler.bind(this);
        this.changekpomegaHandler = this.changekpomegaHandler.bind(this);
        this.changekpxHandler = this.changekpxHandler.bind(this);
        this.changethetamaxHandler = this.changethetamaxHandler.bind(this);
        this.changethetaminHandler = this.changethetaminHandler.bind(this);
        this.changetthetaHandler = this.changetthetaHandler.bind(this);
    }

    componentDidMount(){
        WindContPitchAngleIECService.getWindContPitchAngleIECById(this.state.id).then( (res) =>{
            let windContPitchAngleIEC = res.data;
            this.setState({
                dthetamax: windContPitchAngleIEC.dthetamax,
                dthetamin: windContPitchAngleIEC.dthetamin,
                kic: windContPitchAngleIEC.kic,
                kiomega: windContPitchAngleIEC.kiomega,
                kpc: windContPitchAngleIEC.kpc,
                kpomega: windContPitchAngleIEC.kpomega,
                kpx: windContPitchAngleIEC.kpx,
                thetamax: windContPitchAngleIEC.thetamax,
                thetamin: windContPitchAngleIEC.thetamin,
                ttheta: windContPitchAngleIEC.ttheta
            });
        });
    }

    updateWindContPitchAngleIEC = (e) => {
        e.preventDefault();
        let windContPitchAngleIEC = {
            windContPitchAngleIECId: this.state.id,
            dthetamax: this.state.dthetamax,
            dthetamin: this.state.dthetamin,
            kic: this.state.kic,
            kiomega: this.state.kiomega,
            kpc: this.state.kpc,
            kpomega: this.state.kpomega,
            kpx: this.state.kpx,
            thetamax: this.state.thetamax,
            thetamin: this.state.thetamin,
            ttheta: this.state.ttheta
        };
        console.log('windContPitchAngleIEC => ' + JSON.stringify(windContPitchAngleIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindContPitchAngleIECService.updateWindContPitchAngleIEC(windContPitchAngleIEC).then( res => {
            this.props.history.push('/windContPitchAngleIECs');
        });
    }

    changedthetamaxHandler= (event) => {
        this.setState({dthetamax: event.target.value});
    }
    changedthetaminHandler= (event) => {
        this.setState({dthetamin: event.target.value});
    }
    changekicHandler= (event) => {
        this.setState({kic: event.target.value});
    }
    changekiomegaHandler= (event) => {
        this.setState({kiomega: event.target.value});
    }
    changekpcHandler= (event) => {
        this.setState({kpc: event.target.value});
    }
    changekpomegaHandler= (event) => {
        this.setState({kpomega: event.target.value});
    }
    changekpxHandler= (event) => {
        this.setState({kpx: event.target.value});
    }
    changethetamaxHandler= (event) => {
        this.setState({thetamax: event.target.value});
    }
    changethetaminHandler= (event) => {
        this.setState({thetamin: event.target.value});
    }
    changetthetaHandler= (event) => {
        this.setState({ttheta: event.target.value});
    }

    cancel(){
        this.props.history.push('/windContPitchAngleIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindContPitchAngleIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> dthetamax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> dthetamin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kic: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kiomega: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kpc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kpomega: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kpx: </label>
                                            #formFields( $attribute, 'update')
                                            <label> thetamax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> thetamin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ttheta: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindContPitchAngleIEC}>Save</button>
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

export default UpdateWindContPitchAngleIECComponent
