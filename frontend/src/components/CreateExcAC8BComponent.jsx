import React, { Component } from 'react'
import ExcAC8BService from '../services/ExcAC8BService';

class CreateExcAC8BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                inlim: '',
                ka: '',
                kc: '',
                kd: '',
                kdr: '',
                ke: '',
                kir: '',
                kpr: '',
                ks: '',
                pidlim: '',
                seve1: '',
                seve2: '',
                ta: '',
                tdr: '',
                te: '',
                telim: '',
                ve1: '',
                ve2: '',
                vemin: '',
                vfemax: '',
                vimax: '',
                vimin: '',
                vpidmax: '',
                vpidmin: '',
                vrmax: '',
                vrmin: '',
                vtmult: ''
        }
        this.changeinlimHandler = this.changeinlimHandler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekdHandler = this.changekdHandler.bind(this);
        this.changekdrHandler = this.changekdrHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekirHandler = this.changekirHandler.bind(this);
        this.changekprHandler = this.changekprHandler.bind(this);
        this.changeksHandler = this.changeksHandler.bind(this);
        this.changepidlimHandler = this.changepidlimHandler.bind(this);
        this.changeseve1Handler = this.changeseve1Handler.bind(this);
        this.changeseve2Handler = this.changeseve2Handler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetdrHandler = this.changetdrHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetelimHandler = this.changetelimHandler.bind(this);
        this.changeve1Handler = this.changeve1Handler.bind(this);
        this.changeve2Handler = this.changeve2Handler.bind(this);
        this.changeveminHandler = this.changeveminHandler.bind(this);
        this.changevfemaxHandler = this.changevfemaxHandler.bind(this);
        this.changevimaxHandler = this.changevimaxHandler.bind(this);
        this.changeviminHandler = this.changeviminHandler.bind(this);
        this.changevpidmaxHandler = this.changevpidmaxHandler.bind(this);
        this.changevpidminHandler = this.changevpidminHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
        this.changevtmultHandler = this.changevtmultHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcAC8BService.getExcAC8BById(this.state.id).then( (res) =>{
                let excAC8B = res.data;
                this.setState({
                    inlim: excAC8B.inlim,
                    ka: excAC8B.ka,
                    kc: excAC8B.kc,
                    kd: excAC8B.kd,
                    kdr: excAC8B.kdr,
                    ke: excAC8B.ke,
                    kir: excAC8B.kir,
                    kpr: excAC8B.kpr,
                    ks: excAC8B.ks,
                    pidlim: excAC8B.pidlim,
                    seve1: excAC8B.seve1,
                    seve2: excAC8B.seve2,
                    ta: excAC8B.ta,
                    tdr: excAC8B.tdr,
                    te: excAC8B.te,
                    telim: excAC8B.telim,
                    ve1: excAC8B.ve1,
                    ve2: excAC8B.ve2,
                    vemin: excAC8B.vemin,
                    vfemax: excAC8B.vfemax,
                    vimax: excAC8B.vimax,
                    vimin: excAC8B.vimin,
                    vpidmax: excAC8B.vpidmax,
                    vpidmin: excAC8B.vpidmin,
                    vrmax: excAC8B.vrmax,
                    vrmin: excAC8B.vrmin,
                    vtmult: excAC8B.vtmult
                });
            });
        }        
    }
    saveOrUpdateExcAC8B = (e) => {
        e.preventDefault();
        let excAC8B = {
                excAC8BId: this.state.id,
                inlim: this.state.inlim,
                ka: this.state.ka,
                kc: this.state.kc,
                kd: this.state.kd,
                kdr: this.state.kdr,
                ke: this.state.ke,
                kir: this.state.kir,
                kpr: this.state.kpr,
                ks: this.state.ks,
                pidlim: this.state.pidlim,
                seve1: this.state.seve1,
                seve2: this.state.seve2,
                ta: this.state.ta,
                tdr: this.state.tdr,
                te: this.state.te,
                telim: this.state.telim,
                ve1: this.state.ve1,
                ve2: this.state.ve2,
                vemin: this.state.vemin,
                vfemax: this.state.vfemax,
                vimax: this.state.vimax,
                vimin: this.state.vimin,
                vpidmax: this.state.vpidmax,
                vpidmin: this.state.vpidmin,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin,
                vtmult: this.state.vtmult
            };
        console.log('excAC8B => ' + JSON.stringify(excAC8B));

        // step 5
        if(this.state.id === '_add'){
            excAC8B.excAC8BId=''
            ExcAC8BService.createExcAC8B(excAC8B).then(res =>{
                this.props.history.push('/excAC8Bs');
            });
        }else{
            ExcAC8BService.updateExcAC8B(excAC8B).then( res => {
                this.props.history.push('/excAC8Bs');
            });
        }
    }
    
    changeinlimHandler= (event) => {
        this.setState({inlim: event.target.value});
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
    changekdrHandler= (event) => {
        this.setState({kdr: event.target.value});
    }
    changekeHandler= (event) => {
        this.setState({ke: event.target.value});
    }
    changekirHandler= (event) => {
        this.setState({kir: event.target.value});
    }
    changekprHandler= (event) => {
        this.setState({kpr: event.target.value});
    }
    changeksHandler= (event) => {
        this.setState({ks: event.target.value});
    }
    changepidlimHandler= (event) => {
        this.setState({pidlim: event.target.value});
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
    changetdrHandler= (event) => {
        this.setState({tdr: event.target.value});
    }
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }
    changetelimHandler= (event) => {
        this.setState({telim: event.target.value});
    }
    changeve1Handler= (event) => {
        this.setState({ve1: event.target.value});
    }
    changeve2Handler= (event) => {
        this.setState({ve2: event.target.value});
    }
    changeveminHandler= (event) => {
        this.setState({vemin: event.target.value});
    }
    changevfemaxHandler= (event) => {
        this.setState({vfemax: event.target.value});
    }
    changevimaxHandler= (event) => {
        this.setState({vimax: event.target.value});
    }
    changeviminHandler= (event) => {
        this.setState({vimin: event.target.value});
    }
    changevpidmaxHandler= (event) => {
        this.setState({vpidmax: event.target.value});
    }
    changevpidminHandler= (event) => {
        this.setState({vpidmin: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }
    changevtmultHandler= (event) => {
        this.setState({vtmult: event.target.value});
    }

    cancel(){
        this.props.history.push('/excAC8Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcAC8B</h3>
        }else{
            return <h3 className="text-center">Update ExcAC8B</h3>
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
                                            <label> inlim: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ka: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kd: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kdr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kir: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kpr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ks: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pidlim: </label>
                                            #formFields( $attribute, 'create')
                                            <label> seve1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> seve2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tdr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> te: </label>
                                            #formFields( $attribute, 'create')
                                            <label> telim: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ve1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ve2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vemin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vfemax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vimax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vimin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vpidmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vpidmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vtmult: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcAC8B}>Save</button>
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

export default CreateExcAC8BComponent
