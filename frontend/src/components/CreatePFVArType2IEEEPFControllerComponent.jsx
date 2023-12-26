import React, { Component } from 'react'
import PFVArType2IEEEPFControllerService from '../services/PFVArType2IEEEPFControllerService';

class CreatePFVArType2IEEEPFControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                exlon: '',
                ki: '',
                kp: '',
                pfref: '',
                vclmt: '',
                vref: '',
                vs: ''
        }
        this.changeexlonHandler = this.changeexlonHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changepfrefHandler = this.changepfrefHandler.bind(this);
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
    }
    saveOrUpdatePFVArType2IEEEPFController = (e) => {
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

        // step 5
        if(this.state.id === '_add'){
            pFVArType2IEEEPFController.pFVArType2IEEEPFControllerId=''
            PFVArType2IEEEPFControllerService.createPFVArType2IEEEPFController(pFVArType2IEEEPFController).then(res =>{
                this.props.history.push('/pFVArType2IEEEPFControllers');
            });
        }else{
            PFVArType2IEEEPFControllerService.updatePFVArType2IEEEPFController(pFVArType2IEEEPFController).then( res => {
                this.props.history.push('/pFVArType2IEEEPFControllers');
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PFVArType2IEEEPFController</h3>
        }else{
            return <h3 className="text-center">Update PFVArType2IEEEPFController</h3>
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
                                            <label> pfref: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vclmt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vref: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vs: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePFVArType2IEEEPFController}>Save</button>
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

export default CreatePFVArType2IEEEPFControllerComponent
