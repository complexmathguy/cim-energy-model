import React, { Component } from 'react'
import ExcIEEEST4BService from '../services/ExcIEEEST4BService';

class CreateExcIEEEST4BComponent extends Component {
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
                ta: '',
                thetap: '',
                vbmax: '',
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
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changethetapHandler = this.changethetapHandler.bind(this);
        this.changevbmaxHandler = this.changevbmaxHandler.bind(this);
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
            ExcIEEEST4BService.getExcIEEEST4BById(this.state.id).then( (res) =>{
                let excIEEEST4B = res.data;
                this.setState({
                    kc: excIEEEST4B.kc,
                    kg: excIEEEST4B.kg,
                    ki: excIEEEST4B.ki,
                    kim: excIEEEST4B.kim,
                    kir: excIEEEST4B.kir,
                    kp: excIEEEST4B.kp,
                    kpm: excIEEEST4B.kpm,
                    kpr: excIEEEST4B.kpr,
                    ta: excIEEEST4B.ta,
                    thetap: excIEEEST4B.thetap,
                    vbmax: excIEEEST4B.vbmax,
                    vmmax: excIEEEST4B.vmmax,
                    vmmin: excIEEEST4B.vmmin,
                    vrmax: excIEEEST4B.vrmax,
                    vrmin: excIEEEST4B.vrmin,
                    xl: excIEEEST4B.xl
                });
            });
        }        
    }
    saveOrUpdateExcIEEEST4B = (e) => {
        e.preventDefault();
        let excIEEEST4B = {
                excIEEEST4BId: this.state.id,
                kc: this.state.kc,
                kg: this.state.kg,
                ki: this.state.ki,
                kim: this.state.kim,
                kir: this.state.kir,
                kp: this.state.kp,
                kpm: this.state.kpm,
                kpr: this.state.kpr,
                ta: this.state.ta,
                thetap: this.state.thetap,
                vbmax: this.state.vbmax,
                vmmax: this.state.vmmax,
                vmmin: this.state.vmmin,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin,
                xl: this.state.xl
            };
        console.log('excIEEEST4B => ' + JSON.stringify(excIEEEST4B));

        // step 5
        if(this.state.id === '_add'){
            excIEEEST4B.excIEEEST4BId=''
            ExcIEEEST4BService.createExcIEEEST4B(excIEEEST4B).then(res =>{
                this.props.history.push('/excIEEEST4Bs');
            });
        }else{
            ExcIEEEST4BService.updateExcIEEEST4B(excIEEEST4B).then( res => {
                this.props.history.push('/excIEEEST4Bs');
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
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changethetapHandler= (event) => {
        this.setState({thetap: event.target.value});
    }
    changevbmaxHandler= (event) => {
        this.setState({vbmax: event.target.value});
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
        this.props.history.push('/excIEEEST4Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEST4B</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEST4B</h3>
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
                                            <label> ta: </label>
                                            #formFields( $attribute, 'create')
                                            <label> thetap: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vbmax: </label>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEST4B}>Save</button>
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

export default CreateExcIEEEST4BComponent
