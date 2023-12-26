import React, { Component } from 'react'
import ExcIEEEAC1AService from '../services/ExcIEEEAC1AService';

class CreateExcIEEEAC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                ka: '',
                kc: '',
                kd: '',
                ke: '',
                kf: '',
                seve1: '',
                seve2: '',
                ta: '',
                tb: '',
                tc: '',
                te: '',
                tf: '',
                vamax: '',
                vamin: '',
                ve1: '',
                ve2: '',
                vrmax: '',
                vrmin: ''
        }
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekdHandler = this.changekdHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changeseve1Handler = this.changeseve1Handler.bind(this);
        this.changeseve2Handler = this.changeseve2Handler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changevamaxHandler = this.changevamaxHandler.bind(this);
        this.changevaminHandler = this.changevaminHandler.bind(this);
        this.changeve1Handler = this.changeve1Handler.bind(this);
        this.changeve2Handler = this.changeve2Handler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcIEEEAC1AService.getExcIEEEAC1AById(this.state.id).then( (res) =>{
                let excIEEEAC1A = res.data;
                this.setState({
                    ka: excIEEEAC1A.ka,
                    kc: excIEEEAC1A.kc,
                    kd: excIEEEAC1A.kd,
                    ke: excIEEEAC1A.ke,
                    kf: excIEEEAC1A.kf,
                    seve1: excIEEEAC1A.seve1,
                    seve2: excIEEEAC1A.seve2,
                    ta: excIEEEAC1A.ta,
                    tb: excIEEEAC1A.tb,
                    tc: excIEEEAC1A.tc,
                    te: excIEEEAC1A.te,
                    tf: excIEEEAC1A.tf,
                    vamax: excIEEEAC1A.vamax,
                    vamin: excIEEEAC1A.vamin,
                    ve1: excIEEEAC1A.ve1,
                    ve2: excIEEEAC1A.ve2,
                    vrmax: excIEEEAC1A.vrmax,
                    vrmin: excIEEEAC1A.vrmin
                });
            });
        }        
    }
    saveOrUpdateExcIEEEAC1A = (e) => {
        e.preventDefault();
        let excIEEEAC1A = {
                excIEEEAC1AId: this.state.id,
                ka: this.state.ka,
                kc: this.state.kc,
                kd: this.state.kd,
                ke: this.state.ke,
                kf: this.state.kf,
                seve1: this.state.seve1,
                seve2: this.state.seve2,
                ta: this.state.ta,
                tb: this.state.tb,
                tc: this.state.tc,
                te: this.state.te,
                tf: this.state.tf,
                vamax: this.state.vamax,
                vamin: this.state.vamin,
                ve1: this.state.ve1,
                ve2: this.state.ve2,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin
            };
        console.log('excIEEEAC1A => ' + JSON.stringify(excIEEEAC1A));

        // step 5
        if(this.state.id === '_add'){
            excIEEEAC1A.excIEEEAC1AId=''
            ExcIEEEAC1AService.createExcIEEEAC1A(excIEEEAC1A).then(res =>{
                this.props.history.push('/excIEEEAC1As');
            });
        }else{
            ExcIEEEAC1AService.updateExcIEEEAC1A(excIEEEAC1A).then( res => {
                this.props.history.push('/excIEEEAC1As');
            });
        }
    }
    
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changekcHandler= (event) => {
        this.setState({kc: event.target.value});
    }
    changekdHandler= (event) => {
        this.setState({kd: event.target.value});
    }
    changekeHandler= (event) => {
        this.setState({ke: event.target.value});
    }
    changekfHandler= (event) => {
        this.setState({kf: event.target.value});
    }
    changeseve1Handler= (event) => {
        this.setState({seve1: event.target.value});
    }
    changeseve2Handler= (event) => {
        this.setState({seve2: event.target.value});
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
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }
    changetfHandler= (event) => {
        this.setState({tf: event.target.value});
    }
    changevamaxHandler= (event) => {
        this.setState({vamax: event.target.value});
    }
    changevaminHandler= (event) => {
        this.setState({vamin: event.target.value});
    }
    changeve1Handler= (event) => {
        this.setState({ve1: event.target.value});
    }
    changeve2Handler= (event) => {
        this.setState({ve2: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excIEEEAC1As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEAC1A</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEAC1A</h3>
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
                                            <label> kd: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> seve1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> seve2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> te: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vamax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vamin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ve1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ve2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEAC1A}>Save</button>
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

export default CreateExcIEEEAC1AComponent
