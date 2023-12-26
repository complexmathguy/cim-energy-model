import React, { Component } from 'react'
import PFVArType2IEEEVArControllerService from '../services/PFVArType2IEEEVArControllerService';

class UpdatePFVArType2IEEEVArControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                exlon: '',
                ki: '',
                kp: '',
                qref: '',
                vclmt: '',
                vref: '',
                vs: ''
        }
        this.updatePFVArType2IEEEVArController = this.updatePFVArType2IEEEVArController.bind(this);

        this.changeexlonHandler = this.changeexlonHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changeqrefHandler = this.changeqrefHandler.bind(this);
        this.changevclmtHandler = this.changevclmtHandler.bind(this);
        this.changevrefHandler = this.changevrefHandler.bind(this);
        this.changevsHandler = this.changevsHandler.bind(this);
    }

    componentDidMount(){
        PFVArType2IEEEVArControllerService.getPFVArType2IEEEVArControllerById(this.state.id).then( (res) =>{
            let pFVArType2IEEEVArController = res.data;
            this.setState({
                exlon: pFVArType2IEEEVArController.exlon,
                ki: pFVArType2IEEEVArController.ki,
                kp: pFVArType2IEEEVArController.kp,
                qref: pFVArType2IEEEVArController.qref,
                vclmt: pFVArType2IEEEVArController.vclmt,
                vref: pFVArType2IEEEVArController.vref,
                vs: pFVArType2IEEEVArController.vs
            });
        });
    }

    updatePFVArType2IEEEVArController = (e) => {
        e.preventDefault();
        let pFVArType2IEEEVArController = {
            pFVArType2IEEEVArControllerId: this.state.id,
            exlon: this.state.exlon,
            ki: this.state.ki,
            kp: this.state.kp,
            qref: this.state.qref,
            vclmt: this.state.vclmt,
            vref: this.state.vref,
            vs: this.state.vs
        };
        console.log('pFVArType2IEEEVArController => ' + JSON.stringify(pFVArType2IEEEVArController));
        console.log('id => ' + JSON.stringify(this.state.id));
        PFVArType2IEEEVArControllerService.updatePFVArType2IEEEVArController(pFVArType2IEEEVArController).then( res => {
            this.props.history.push('/pFVArType2IEEEVArControllers');
        });
    }

    changeexlonHandler= (event) => {
        this.setState({exlon: event.target.value});
    }
    changekiHandler= (event) => {
        this.setState({ki: event.target.value});
    }
    changekpHandler= (event) => {
        this.setState({kp: event.target.value});
    }
    changeqrefHandler= (event) => {
        this.setState({qref: event.target.value});
    }
    changevclmtHandler= (event) => {
        this.setState({vclmt: event.target.value});
    }
    changevrefHandler= (event) => {
        this.setState({vref: event.target.value});
    }
    changevsHandler= (event) => {
        this.setState({vs: event.target.value});
    }

    cancel(){
        this.props.history.push('/pFVArType2IEEEVArControllers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PFVArType2IEEEVArController</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> exlon: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> qref: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vclmt: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vref: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vs: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePFVArType2IEEEVArController}>Save</button>
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

export default UpdatePFVArType2IEEEVArControllerComponent
