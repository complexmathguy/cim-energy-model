import React, { Component } from 'react'
import PssPTIST1Service from '../services/PssPTIST1Service';

class CreatePssPTIST1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                dtc: '',
                dtf: '',
                dtp: '',
                k: '',
                m: '',
                t1: '',
                t2: '',
                t3: '',
                t4: '',
                tf: '',
                tp: ''
        }
        this.changedtcHandler = this.changedtcHandler.bind(this);
        this.changedtfHandler = this.changedtfHandler.bind(this);
        this.changedtpHandler = this.changedtpHandler.bind(this);
        this.changekHandler = this.changekHandler.bind(this);
        this.changemHandler = this.changemHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changetpHandler = this.changetpHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PssPTIST1Service.getPssPTIST1ById(this.state.id).then( (res) =>{
                let pssPTIST1 = res.data;
                this.setState({
                    dtc: pssPTIST1.dtc,
                    dtf: pssPTIST1.dtf,
                    dtp: pssPTIST1.dtp,
                    k: pssPTIST1.k,
                    m: pssPTIST1.m,
                    t1: pssPTIST1.t1,
                    t2: pssPTIST1.t2,
                    t3: pssPTIST1.t3,
                    t4: pssPTIST1.t4,
                    tf: pssPTIST1.tf,
                    tp: pssPTIST1.tp
                });
            });
        }        
    }
    saveOrUpdatePssPTIST1 = (e) => {
        e.preventDefault();
        let pssPTIST1 = {
                pssPTIST1Id: this.state.id,
                dtc: this.state.dtc,
                dtf: this.state.dtf,
                dtp: this.state.dtp,
                k: this.state.k,
                m: this.state.m,
                t1: this.state.t1,
                t2: this.state.t2,
                t3: this.state.t3,
                t4: this.state.t4,
                tf: this.state.tf,
                tp: this.state.tp
            };
        console.log('pssPTIST1 => ' + JSON.stringify(pssPTIST1));

        // step 5
        if(this.state.id === '_add'){
            pssPTIST1.pssPTIST1Id=''
            PssPTIST1Service.createPssPTIST1(pssPTIST1).then(res =>{
                this.props.history.push('/pssPTIST1s');
            });
        }else{
            PssPTIST1Service.updatePssPTIST1(pssPTIST1).then( res => {
                this.props.history.push('/pssPTIST1s');
            });
        }
    }
    
    changedtcHandler= (event) => {
        this.setState({dtc: event.target.value});
    }
    changedtfHandler= (event) => {
        this.setState({dtf: event.target.value});
    }
    changedtpHandler= (event) => {
        this.setState({dtp: event.target.value});
    }
    changekHandler= (event) => {
        this.setState({k: event.target.value});
    }
    changemHandler= (event) => {
        this.setState({m: event.target.value});
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
    changetfHandler= (event) => {
        this.setState({tf: event.target.value});
    }
    changetpHandler= (event) => {
        this.setState({tp: event.target.value});
    }

    cancel(){
        this.props.history.push('/pssPTIST1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PssPTIST1</h3>
        }else{
            return <h3 className="text-center">Update PssPTIST1</h3>
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
                                            <label> dtc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> dtf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> dtp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> k: </label>
                                            #formFields( $attribute, 'create')
                                            <label> m: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tp: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePssPTIST1}>Save</button>
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

export default CreatePssPTIST1Component
