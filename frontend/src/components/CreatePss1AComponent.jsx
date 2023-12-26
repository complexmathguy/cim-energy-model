import React, { Component } from 'react'
import Pss1AService from '../services/Pss1AService';

class CreatePss1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                a1: '',
                a2: '',
                a3: '',
                a4: '',
                a5: '',
                a6: '',
                a7: '',
                a8: '',
                inputSignalType: '',
                kd: '',
                ks: '',
                t1: '',
                t2: '',
                t3: '',
                t4: '',
                t5: '',
                t6: '',
                tdelay: '',
                vcl: '',
                vcu: '',
                vrmax: '',
                vrmin: ''
        }
        this.changea1Handler = this.changea1Handler.bind(this);
        this.changea2Handler = this.changea2Handler.bind(this);
        this.changea3Handler = this.changea3Handler.bind(this);
        this.changea4Handler = this.changea4Handler.bind(this);
        this.changea5Handler = this.changea5Handler.bind(this);
        this.changea6Handler = this.changea6Handler.bind(this);
        this.changea7Handler = this.changea7Handler.bind(this);
        this.changea8Handler = this.changea8Handler.bind(this);
        this.changeinputSignalTypeHandler = this.changeinputSignalTypeHandler.bind(this);
        this.changekdHandler = this.changekdHandler.bind(this);
        this.changeksHandler = this.changeksHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changet5Handler = this.changet5Handler.bind(this);
        this.changet6Handler = this.changet6Handler.bind(this);
        this.changetdelayHandler = this.changetdelayHandler.bind(this);
        this.changevclHandler = this.changevclHandler.bind(this);
        this.changevcuHandler = this.changevcuHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            Pss1AService.getPss1AById(this.state.id).then( (res) =>{
                let pss1A = res.data;
                this.setState({
                    a1: pss1A.a1,
                    a2: pss1A.a2,
                    a3: pss1A.a3,
                    a4: pss1A.a4,
                    a5: pss1A.a5,
                    a6: pss1A.a6,
                    a7: pss1A.a7,
                    a8: pss1A.a8,
                    inputSignalType: pss1A.inputSignalType,
                    kd: pss1A.kd,
                    ks: pss1A.ks,
                    t1: pss1A.t1,
                    t2: pss1A.t2,
                    t3: pss1A.t3,
                    t4: pss1A.t4,
                    t5: pss1A.t5,
                    t6: pss1A.t6,
                    tdelay: pss1A.tdelay,
                    vcl: pss1A.vcl,
                    vcu: pss1A.vcu,
                    vrmax: pss1A.vrmax,
                    vrmin: pss1A.vrmin
                });
            });
        }        
    }
    saveOrUpdatePss1A = (e) => {
        e.preventDefault();
        let pss1A = {
                pss1AId: this.state.id,
                a1: this.state.a1,
                a2: this.state.a2,
                a3: this.state.a3,
                a4: this.state.a4,
                a5: this.state.a5,
                a6: this.state.a6,
                a7: this.state.a7,
                a8: this.state.a8,
                inputSignalType: this.state.inputSignalType,
                kd: this.state.kd,
                ks: this.state.ks,
                t1: this.state.t1,
                t2: this.state.t2,
                t3: this.state.t3,
                t4: this.state.t4,
                t5: this.state.t5,
                t6: this.state.t6,
                tdelay: this.state.tdelay,
                vcl: this.state.vcl,
                vcu: this.state.vcu,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin
            };
        console.log('pss1A => ' + JSON.stringify(pss1A));

        // step 5
        if(this.state.id === '_add'){
            pss1A.pss1AId=''
            Pss1AService.createPss1A(pss1A).then(res =>{
                this.props.history.push('/pss1As');
            });
        }else{
            Pss1AService.updatePss1A(pss1A).then( res => {
                this.props.history.push('/pss1As');
            });
        }
    }
    
    changea1Handler= (event) => {
        this.setState({a1: event.target.value});
    }
    changea2Handler= (event) => {
        this.setState({a2: event.target.value});
    }
    changea3Handler= (event) => {
        this.setState({a3: event.target.value});
    }
    changea4Handler= (event) => {
        this.setState({a4: event.target.value});
    }
    changea5Handler= (event) => {
        this.setState({a5: event.target.value});
    }
    changea6Handler= (event) => {
        this.setState({a6: event.target.value});
    }
    changea7Handler= (event) => {
        this.setState({a7: event.target.value});
    }
    changea8Handler= (event) => {
        this.setState({a8: event.target.value});
    }
    changeinputSignalTypeHandler= (event) => {
        this.setState({inputSignalType: event.target.value});
    }
    changekdHandler= (event) => {
        this.setState({kd: event.target.value});
    }
    changeksHandler= (event) => {
        this.setState({ks: event.target.value});
    }
    changet1Handler= (event) => {
        this.setState({t1: event.target.value});
    }
    changet2Handler= (event) => {
        this.setState({t2: event.target.value});
    }
    changet3Handler= (event) => {
        this.setState({t3: event.target.value});
    }
    changet4Handler= (event) => {
        this.setState({t4: event.target.value});
    }
    changet5Handler= (event) => {
        this.setState({t5: event.target.value});
    }
    changet6Handler= (event) => {
        this.setState({t6: event.target.value});
    }
    changetdelayHandler= (event) => {
        this.setState({tdelay: event.target.value});
    }
    changevclHandler= (event) => {
        this.setState({vcl: event.target.value});
    }
    changevcuHandler= (event) => {
        this.setState({vcu: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/pss1As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Pss1A</h3>
        }else{
            return <h3 className="text-center">Update Pss1A</h3>
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
                                            <label> a1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> a2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> a3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> a4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> a5: </label>
                                            #formFields( $attribute, 'create')
                                            <label> a6: </label>
                                            #formFields( $attribute, 'create')
                                            <label> a7: </label>
                                            #formFields( $attribute, 'create')
                                            <label> a8: </label>
                                            #formFields( $attribute, 'create')
                                            <label> inputSignalType: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kd: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ks: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t5: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t6: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tdelay: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vcl: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vcu: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePss1A}>Save</button>
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

export default CreatePss1AComponent
