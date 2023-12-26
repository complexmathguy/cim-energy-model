import React, { Component } from 'react'
import ExcOEX3TService from '../services/ExcOEX3TService';

class CreateExcOEX3TComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                e1: '',
                e2: '',
                ka: '',
                kc: '',
                kd: '',
                ke: '',
                kf: '',
                see1: '',
                see2: '',
                t1: '',
                t2: '',
                t3: '',
                t4: '',
                t5: '',
                t6: '',
                te: '',
                tf: '',
                vrmax: '',
                vrmin: ''
        }
        this.changee1Handler = this.changee1Handler.bind(this);
        this.changee2Handler = this.changee2Handler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekdHandler = this.changekdHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changesee1Handler = this.changesee1Handler.bind(this);
        this.changesee2Handler = this.changesee2Handler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changet5Handler = this.changet5Handler.bind(this);
        this.changet6Handler = this.changet6Handler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcOEX3TService.getExcOEX3TById(this.state.id).then( (res) =>{
                let excOEX3T = res.data;
                this.setState({
                    e1: excOEX3T.e1,
                    e2: excOEX3T.e2,
                    ka: excOEX3T.ka,
                    kc: excOEX3T.kc,
                    kd: excOEX3T.kd,
                    ke: excOEX3T.ke,
                    kf: excOEX3T.kf,
                    see1: excOEX3T.see1,
                    see2: excOEX3T.see2,
                    t1: excOEX3T.t1,
                    t2: excOEX3T.t2,
                    t3: excOEX3T.t3,
                    t4: excOEX3T.t4,
                    t5: excOEX3T.t5,
                    t6: excOEX3T.t6,
                    te: excOEX3T.te,
                    tf: excOEX3T.tf,
                    vrmax: excOEX3T.vrmax,
                    vrmin: excOEX3T.vrmin
                });
            });
        }        
    }
    saveOrUpdateExcOEX3T = (e) => {
        e.preventDefault();
        let excOEX3T = {
                excOEX3TId: this.state.id,
                e1: this.state.e1,
                e2: this.state.e2,
                ka: this.state.ka,
                kc: this.state.kc,
                kd: this.state.kd,
                ke: this.state.ke,
                kf: this.state.kf,
                see1: this.state.see1,
                see2: this.state.see2,
                t1: this.state.t1,
                t2: this.state.t2,
                t3: this.state.t3,
                t4: this.state.t4,
                t5: this.state.t5,
                t6: this.state.t6,
                te: this.state.te,
                tf: this.state.tf,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin
            };
        console.log('excOEX3T => ' + JSON.stringify(excOEX3T));

        // step 5
        if(this.state.id === '_add'){
            excOEX3T.excOEX3TId=''
            ExcOEX3TService.createExcOEX3T(excOEX3T).then(res =>{
                this.props.history.push('/excOEX3Ts');
            });
        }else{
            ExcOEX3TService.updateExcOEX3T(excOEX3T).then( res => {
                this.props.history.push('/excOEX3Ts');
            });
        }
    }
    
    changee1Handler= (event) => {
        this.setState({e1: event.target.value});
    }
    changee2Handler= (event) => {
        this.setState({e2: event.target.value});
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
    changesee1Handler= (event) => {
        this.setState({see1: event.target.value});
    }
    changesee2Handler= (event) => {
        this.setState({see2: event.target.value});
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
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }
    changetfHandler= (event) => {
        this.setState({tf: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excOEX3Ts');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcOEX3T</h3>
        }else{
            return <h3 className="text-center">Update ExcOEX3T</h3>
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
                                            <label> see1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> see2: </label>
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
                                            <label> te: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcOEX3T}>Save</button>
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

export default CreateExcOEX3TComponent
