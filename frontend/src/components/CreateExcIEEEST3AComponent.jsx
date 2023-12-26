import React, { Component } from 'react'
import ExcIEEEST3AService from '../services/ExcIEEEST3AService';

class CreateExcIEEEST3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                ka: '',
                kc: '',
                kg: '',
                ki: '',
                km: '',
                kp: '',
                ta: '',
                tb: '',
                tc: '',
                thetap: '',
                tm: '',
                vbmax: '',
                vgmax: '',
                vimax: '',
                vimin: '',
                vmmax: '',
                vmmin: '',
                vrmax: '',
                vrmin: '',
                xl: ''
        }
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekgHandler = this.changekgHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekmHandler = this.changekmHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changethetapHandler = this.changethetapHandler.bind(this);
        this.changetmHandler = this.changetmHandler.bind(this);
        this.changevbmaxHandler = this.changevbmaxHandler.bind(this);
        this.changevgmaxHandler = this.changevgmaxHandler.bind(this);
        this.changevimaxHandler = this.changevimaxHandler.bind(this);
        this.changeviminHandler = this.changeviminHandler.bind(this);
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
            ExcIEEEST3AService.getExcIEEEST3AById(this.state.id).then( (res) =>{
                let excIEEEST3A = res.data;
                this.setState({
                    ka: excIEEEST3A.ka,
                    kc: excIEEEST3A.kc,
                    kg: excIEEEST3A.kg,
                    ki: excIEEEST3A.ki,
                    km: excIEEEST3A.km,
                    kp: excIEEEST3A.kp,
                    ta: excIEEEST3A.ta,
                    tb: excIEEEST3A.tb,
                    tc: excIEEEST3A.tc,
                    thetap: excIEEEST3A.thetap,
                    tm: excIEEEST3A.tm,
                    vbmax: excIEEEST3A.vbmax,
                    vgmax: excIEEEST3A.vgmax,
                    vimax: excIEEEST3A.vimax,
                    vimin: excIEEEST3A.vimin,
                    vmmax: excIEEEST3A.vmmax,
                    vmmin: excIEEEST3A.vmmin,
                    vrmax: excIEEEST3A.vrmax,
                    vrmin: excIEEEST3A.vrmin,
                    xl: excIEEEST3A.xl
                });
            });
        }        
    }
    saveOrUpdateExcIEEEST3A = (e) => {
        e.preventDefault();
        let excIEEEST3A = {
                excIEEEST3AId: this.state.id,
                ka: this.state.ka,
                kc: this.state.kc,
                kg: this.state.kg,
                ki: this.state.ki,
                km: this.state.km,
                kp: this.state.kp,
                ta: this.state.ta,
                tb: this.state.tb,
                tc: this.state.tc,
                thetap: this.state.thetap,
                tm: this.state.tm,
                vbmax: this.state.vbmax,
                vgmax: this.state.vgmax,
                vimax: this.state.vimax,
                vimin: this.state.vimin,
                vmmax: this.state.vmmax,
                vmmin: this.state.vmmin,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin,
                xl: this.state.xl
            };
        console.log('excIEEEST3A => ' + JSON.stringify(excIEEEST3A));

        // step 5
        if(this.state.id === '_add'){
            excIEEEST3A.excIEEEST3AId=''
            ExcIEEEST3AService.createExcIEEEST3A(excIEEEST3A).then(res =>{
                this.props.history.push('/excIEEEST3As');
            });
        }else{
            ExcIEEEST3AService.updateExcIEEEST3A(excIEEEST3A).then( res => {
                this.props.history.push('/excIEEEST3As');
            });
        }
    }
    
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
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
    changekmHandler= (event) => {
        this.setState({km: event.target.value});
    }
    changekpHandler= (event) => {
        this.setState({kp: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changethetapHandler= (event) => {
        this.setState({thetap: event.target.value});
    }
    changetmHandler= (event) => {
        this.setState({tm: event.target.value});
    }
    changevbmaxHandler= (event) => {
        this.setState({vbmax: event.target.value});
    }
    changevgmaxHandler= (event) => {
        this.setState({vgmax: event.target.value});
    }
    changevimaxHandler= (event) => {
        this.setState({vimax: event.target.value});
    }
    changeviminHandler= (event) => {
        this.setState({vimin: event.target.value});
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
        this.props.history.push('/excIEEEST3As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEST3A</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEST3A</h3>
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
                                            <label> ka: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kg: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'create')
                                            <label> km: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> thetap: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tm: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vbmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vgmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vimax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vimin: </label>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEST3A}>Save</button>
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

export default CreateExcIEEEST3AComponent
