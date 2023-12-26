import React, { Component } from 'react'
import PFVArType2IEEEPFControllerService from '../services/PFVArType2IEEEPFControllerService';

class UpdatePFVArType2IEEEPFControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                exlon: '',
                ki: '',
                kp: '',
                pfref: '',
                vclmt: '',
                vref: '',
                vs: ''
        }
        this.updatePFVArType2IEEEPFController = this.updatePFVArType2IEEEPFController.bind(this);

        this.changeexlonHandler = this.changeexlonHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changepfrefHandler = this.changepfrefHandler.bind(this);
        this.changevclmtHandler = this.changevclmtHandler.bind(this);
        this.changevrefHandler = this.changevrefHandler.bind(this);
        this.changevsHandler = this.changevsHandler.bind(this);
    }

    componentDidMount(){
        PFVArType2IEEEPFControllerService.getPFVArType2IEEEPFControllerById(this.state.id).then( (res) =>{
            let pFVArType2IEEEPFController = res.data;
            this.setState({
                exlon: pFVArType2IEEEPFController.exlon,
                ki: pFVArType2IEEEPFController.ki,
                kp: pFVArType2IEEEPFController.kp,
                pfref: pFVArType2IEEEPFController.pfref,
                vclmt: pFVArType2IEEEPFController.vclmt,
                vref: pFVArType2IEEEPFController.vref,
                vs: pFVArType2IEEEPFController.vs
            });
        });
    }

    updatePFVArType2IEEEPFController = (e) => {
        e.preventDefault();
        let pFVArType2IEEEPFController = {
            pFVArType2IEEEPFControllerId: this.state.id,
            exlon: this.state.exlon,
            ki: this.state.ki,
            kp: this.state.kp,
            pfref: this.state.pfref,
            vclmt: this.state.vclmt,
            vref: this.state.vref,
            vs: this.state.vs
        };
        console.log('pFVArType2IEEEPFController => ' + JSON.stringify(pFVArType2IEEEPFController));
        console.log('id => ' + JSON.stringify(this.state.id));
        PFVArType2IEEEPFControllerService.updatePFVArType2IEEEPFController(pFVArType2IEEEPFController).then( res => {
            this.props.history.push('/pFVArType2IEEEPFControllers');
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
    changepfrefHandler= (event) => {
        this.setState({pfref: event.target.value});
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
        this.props.history.push('/pFVArType2IEEEPFControllers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PFVArType2IEEEPFController</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> exlon: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pfref: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vclmt: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vref: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vs: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePFVArType2IEEEPFController}>Save</button>
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

export default UpdatePFVArType2IEEEPFControllerComponent
