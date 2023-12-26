import React, { Component } from 'react'
import ExcPICService from '../services/ExcPICService';

class CreateExcPICComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                e1: '',
                e2: '',
                efdmax: '',
                efdmin: '',
                ka: '',
                kc: '',
                ke: '',
                kf: '',
                ki: '',
                kp: '',
                se1: '',
                se2: '',
                ta1: '',
                ta2: '',
                ta3: '',
                ta4: '',
                te: '',
                tf1: '',
                tf2: '',
                vr1: '',
                vr2: '',
                vrmax: '',
                vrmin: ''
        }
        this.changee1Handler = this.changee1Handler.bind(this);
        this.changee2Handler = this.changee2Handler.bind(this);
        this.changeefdmaxHandler = this.changeefdmaxHandler.bind(this);
        this.changeefdminHandler = this.changeefdminHandler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changese1Handler = this.changese1Handler.bind(this);
        this.changese2Handler = this.changese2Handler.bind(this);
        this.changeta1Handler = this.changeta1Handler.bind(this);
        this.changeta2Handler = this.changeta2Handler.bind(this);
        this.changeta3Handler = this.changeta3Handler.bind(this);
        this.changeta4Handler = this.changeta4Handler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetf1Handler = this.changetf1Handler.bind(this);
        this.changetf2Handler = this.changetf2Handler.bind(this);
        this.changevr1Handler = this.changevr1Handler.bind(this);
        this.changevr2Handler = this.changevr2Handler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcPICService.getExcPICById(this.state.id).then( (res) =>{
                let excPIC = res.data;
                this.setState({
                    e1: excPIC.e1,
                    e2: excPIC.e2,
                    efdmax: excPIC.efdmax,
                    efdmin: excPIC.efdmin,
                    ka: excPIC.ka,
                    kc: excPIC.kc,
                    ke: excPIC.ke,
                    kf: excPIC.kf,
                    ki: excPIC.ki,
                    kp: excPIC.kp,
                    se1: excPIC.se1,
                    se2: excPIC.se2,
                    ta1: excPIC.ta1,
                    ta2: excPIC.ta2,
                    ta3: excPIC.ta3,
                    ta4: excPIC.ta4,
                    te: excPIC.te,
                    tf1: excPIC.tf1,
                    tf2: excPIC.tf2,
                    vr1: excPIC.vr1,
                    vr2: excPIC.vr2,
                    vrmax: excPIC.vrmax,
                    vrmin: excPIC.vrmin
                });
            });
        }        
    }
    saveOrUpdateExcPIC = (e) => {
        e.preventDefault();
        let excPIC = {
                excPICId: this.state.id,
                e1: this.state.e1,
                e2: this.state.e2,
                efdmax: this.state.efdmax,
                efdmin: this.state.efdmin,
                ka: this.state.ka,
                kc: this.state.kc,
                ke: this.state.ke,
                kf: this.state.kf,
                ki: this.state.ki,
                kp: this.state.kp,
                se1: this.state.se1,
                se2: this.state.se2,
                ta1: this.state.ta1,
                ta2: this.state.ta2,
                ta3: this.state.ta3,
                ta4: this.state.ta4,
                te: this.state.te,
                tf1: this.state.tf1,
                tf2: this.state.tf2,
                vr1: this.state.vr1,
                vr2: this.state.vr2,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin
            };
        console.log('excPIC => ' + JSON.stringify(excPIC));

        // step 5
        if(this.state.id === '_add'){
            excPIC.excPICId=''
            ExcPICService.createExcPIC(excPIC).then(res =>{
                this.props.history.push('/excPICs');
            });
        }else{
            ExcPICService.updateExcPIC(excPIC).then( res => {
                this.props.history.push('/excPICs');
            });
        }
    }
    
    changee1Handler= (event) => {
        this.setState({e1: event.target.value});
    }
    changee2Handler= (event) => {
        this.setState({e2: event.target.value});
    }
    changeefdmaxHandler= (event) => {
        this.setState({efdmax: event.target.value});
    }
    changeefdminHandler= (event) => {
        this.setState({efdmin: event.target.value});
    }
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changekcHandler= (event) => {
        this.setState({kc: event.target.value});
    }
    changekeHandler= (event) => {
        this.setState({ke: event.target.value});
    }
    changekfHandler= (event) => {
        this.setState({kf: event.target.value});
    }
    changekiHandler= (event) => {
        this.setState({ki: event.target.value});
    }
    changekpHandler= (event) => {
        this.setState({kp: event.target.value});
    }
    changese1Handler= (event) => {
        this.setState({se1: event.target.value});
    }
    changese2Handler= (event) => {
        this.setState({se2: event.target.value});
    }
    changeta1Handler= (event) => {
        this.setState({ta1: event.target.value});
    }
    changeta2Handler= (event) => {
        this.setState({ta2: event.target.value});
    }
    changeta3Handler= (event) => {
        this.setState({ta3: event.target.value});
    }
    changeta4Handler= (event) => {
        this.setState({ta4: event.target.value});
    }
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }
    changetf1Handler= (event) => {
        this.setState({tf1: event.target.value});
    }
    changetf2Handler= (event) => {
        this.setState({tf2: event.target.value});
    }
    changevr1Handler= (event) => {
        this.setState({vr1: event.target.value});
    }
    changevr2Handler= (event) => {
        this.setState({vr2: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excPICs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcPIC</h3>
        }else{
            return <h3 className="text-center">Update ExcPIC</h3>
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
                                            <label> e1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> e2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> efdmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> efdmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ka: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> se1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> se2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ta1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ta2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ta3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ta4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> te: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tf1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tf2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vr1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vr2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcPIC}>Save</button>
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

export default CreateExcPICComponent
