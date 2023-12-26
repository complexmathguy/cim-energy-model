import React, { Component } from 'react'
import ExcST4BService from '../services/ExcST4BService';

class CreateExcST4BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                kc: '',
                kg: '',
                ki: '',
                kim: '',
                kir: '',
                kp: '',
                kpm: '',
                kpr: '',
                lvgate: '',
                ta: '',
                thetap: '',
                uel: '',
                vbmax: '',
                vgmax: '',
                vmmax: '',
                vmmin: '',
                vrmax: '',
                vrmin: '',
                xl: ''
        }
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekgHandler = this.changekgHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekimHandler = this.changekimHandler.bind(this);
        this.changekirHandler = this.changekirHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changekpmHandler = this.changekpmHandler.bind(this);
        this.changekprHandler = this.changekprHandler.bind(this);
        this.changelvgateHandler = this.changelvgateHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changethetapHandler = this.changethetapHandler.bind(this);
        this.changeuelHandler = this.changeuelHandler.bind(this);
        this.changevbmaxHandler = this.changevbmaxHandler.bind(this);
        this.changevgmaxHandler = this.changevgmaxHandler.bind(this);
        this.changevmmaxHandler = this.changevmmaxHandler.bind(this);
        this.changevmminHandler = this.changevmminHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
        this.changexlHandler = this.changexlHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcST4BService.getExcST4BById(this.state.id).then( (res) =>{
                let excST4B = res.data;
                this.setState({
                    kc: excST4B.kc,
                    kg: excST4B.kg,
                    ki: excST4B.ki,
                    kim: excST4B.kim,
                    kir: excST4B.kir,
                    kp: excST4B.kp,
                    kpm: excST4B.kpm,
                    kpr: excST4B.kpr,
                    lvgate: excST4B.lvgate,
                    ta: excST4B.ta,
                    thetap: excST4B.thetap,
                    uel: excST4B.uel,
                    vbmax: excST4B.vbmax,
                    vgmax: excST4B.vgmax,
                    vmmax: excST4B.vmmax,
                    vmmin: excST4B.vmmin,
                    vrmax: excST4B.vrmax,
                    vrmin: excST4B.vrmin,
                    xl: excST4B.xl
                });
            });
        }        
    }
    saveOrUpdateExcST4B = (e) => {
        e.preventDefault();
        let excST4B = {
                excST4BId: this.state.id,
                kc: this.state.kc,
                kg: this.state.kg,
                ki: this.state.ki,
                kim: this.state.kim,
                kir: this.state.kir,
                kp: this.state.kp,
                kpm: this.state.kpm,
                kpr: this.state.kpr,
                lvgate: this.state.lvgate,
                ta: this.state.ta,
                thetap: this.state.thetap,
                uel: this.state.uel,
                vbmax: this.state.vbmax,
                vgmax: this.state.vgmax,
                vmmax: this.state.vmmax,
                vmmin: this.state.vmmin,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin,
                xl: this.state.xl
            };
        console.log('excST4B => ' + JSON.stringify(excST4B));

        // step 5
        if(this.state.id === '_add'){
            excST4B.excST4BId=''
            ExcST4BService.createExcST4B(excST4B).then(res =>{
                this.props.history.push('/excST4Bs');
            });
        }else{
            ExcST4BService.updateExcST4B(excST4B).then( res => {
                this.props.history.push('/excST4Bs');
            });
        }
    }
    
    changekcHandler= (event) => {
        this.setState({kc: event.target.value});
    }
    changekgHandler= (event) => {
        this.setState({kg: event.target.value});
    }
    changekiHandler= (event) => {
        this.setState({ki: event.target.value});
    }
    changekimHandler= (event) => {
        this.setState({kim: event.target.value});
    }
    changekirHandler= (event) => {
        this.setState({kir: event.target.value});
    }
    changekpHandler= (event) => {
        this.setState({kp: event.target.value});
    }
    changekpmHandler= (event) => {
        this.setState({kpm: event.target.value});
    }
    changekprHandler= (event) => {
        this.setState({kpr: event.target.value});
    }
    changelvgateHandler= (event) => {
        this.setState({lvgate: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changethetapHandler= (event) => {
        this.setState({thetap: event.target.value});
    }
    changeuelHandler= (event) => {
        this.setState({uel: event.target.value});
    }
    changevbmaxHandler= (event) => {
        this.setState({vbmax: event.target.value});
    }
    changevgmaxHandler= (event) => {
        this.setState({vgmax: event.target.value});
    }
    changevmmaxHandler= (event) => {
        this.setState({vmmax: event.target.value});
    }
    changevmminHandler= (event) => {
        this.setState({vmmin: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }
    changexlHandler= (event) => {
        this.setState({xl: event.target.value});
    }

    cancel(){
        this.props.history.push('/excST4Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcST4B</h3>
        }else{
            return <h3 className="text-center">Update ExcST4B</h3>
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
                                            <label> kc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kg: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kim: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kir: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kpm: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kpr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> lvgate: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'create')
                                            <label> thetap: </label>
                                            #formFields( $attribute, 'create')
                                            <label> uel: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vbmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vgmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vmmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vmmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xl: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcST4B}>Save</button>
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

export default CreateExcST4BComponent
