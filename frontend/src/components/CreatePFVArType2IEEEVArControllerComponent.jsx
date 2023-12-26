import React, { Component } from 'react'
import PFVArType2IEEEVArControllerService from '../services/PFVArType2IEEEVArControllerService';

class CreatePFVArType2IEEEVArControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                exlon: '',
                ki: '',
                kp: '',
                qref: '',
                vclmt: '',
                vref: '',
                vs: ''
        }
        this.changeexlonHandler = this.changeexlonHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changeqrefHandler = this.changeqrefHandler.bind(this);
        this.changevclmtHandler = this.changevclmtHandler.bind(this);
        this.changevrefHandler = this.changevrefHandler.bind(this);
        this.changevsHandler = this.changevsHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
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
    }
    saveOrUpdatePFVArType2IEEEVArController = (e) => {
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

        // step 5
        if(this.state.id === '_add'){
            pFVArType2IEEEVArController.pFVArType2IEEEVArControllerId=''
            PFVArType2IEEEVArControllerService.createPFVArType2IEEEVArController(pFVArType2IEEEVArController).then(res =>{
                this.props.history.push('/pFVArType2IEEEVArControllers');
            });
        }else{
            PFVArType2IEEEVArControllerService.updatePFVArType2IEEEVArController(pFVArType2IEEEVArController).then( res => {
                this.props.history.push('/pFVArType2IEEEVArControllers');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PFVArType2IEEEVArController</h3>
        }else{
            return <h3 className="text-center">Update PFVArType2IEEEVArController</h3>
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
                                            <label> exlon: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> qref: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vclmt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vref: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vs: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePFVArType2IEEEVArController}>Save</button>
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

export default CreatePFVArType2IEEEVArControllerComponent
