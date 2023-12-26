import React, { Component } from 'react'
import Pss2STService from '../services/Pss2STService';

class CreatePss2STComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                inputSignal1Type: '',
                inputSignal2Type: '',
                k1: '',
                k2: '',
                lsmax: '',
                lsmin: '',
                t1: '',
                t10: '',
                t2: '',
                t3: '',
                t4: '',
                t5: '',
                t6: '',
                t7: '',
                t8: '',
                t9: '',
                vcl: '',
                vcu: ''
        }
        this.changeinputSignal1TypeHandler = this.changeinputSignal1TypeHandler.bind(this);
        this.changeinputSignal2TypeHandler = this.changeinputSignal2TypeHandler.bind(this);
        this.changek1Handler = this.changek1Handler.bind(this);
        this.changek2Handler = this.changek2Handler.bind(this);
        this.changelsmaxHandler = this.changelsmaxHandler.bind(this);
        this.changelsminHandler = this.changelsminHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet10Handler = this.changet10Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changet5Handler = this.changet5Handler.bind(this);
        this.changet6Handler = this.changet6Handler.bind(this);
        this.changet7Handler = this.changet7Handler.bind(this);
        this.changet8Handler = this.changet8Handler.bind(this);
        this.changet9Handler = this.changet9Handler.bind(this);
        this.changevclHandler = this.changevclHandler.bind(this);
        this.changevcuHandler = this.changevcuHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            Pss2STService.getPss2STById(this.state.id).then( (res) =>{
                let pss2ST = res.data;
                this.setState({
                    inputSignal1Type: pss2ST.inputSignal1Type,
                    inputSignal2Type: pss2ST.inputSignal2Type,
                    k1: pss2ST.k1,
                    k2: pss2ST.k2,
                    lsmax: pss2ST.lsmax,
                    lsmin: pss2ST.lsmin,
                    t1: pss2ST.t1,
                    t10: pss2ST.t10,
                    t2: pss2ST.t2,
                    t3: pss2ST.t3,
                    t4: pss2ST.t4,
                    t5: pss2ST.t5,
                    t6: pss2ST.t6,
                    t7: pss2ST.t7,
                    t8: pss2ST.t8,
                    t9: pss2ST.t9,
                    vcl: pss2ST.vcl,
                    vcu: pss2ST.vcu
                });
            });
        }        
    }
    saveOrUpdatePss2ST = (e) => {
        e.preventDefault();
        let pss2ST = {
                pss2STId: this.state.id,
                inputSignal1Type: this.state.inputSignal1Type,
                inputSignal2Type: this.state.inputSignal2Type,
                k1: this.state.k1,
                k2: this.state.k2,
                lsmax: this.state.lsmax,
                lsmin: this.state.lsmin,
                t1: this.state.t1,
                t10: this.state.t10,
                t2: this.state.t2,
                t3: this.state.t3,
                t4: this.state.t4,
                t5: this.state.t5,
                t6: this.state.t6,
                t7: this.state.t7,
                t8: this.state.t8,
                t9: this.state.t9,
                vcl: this.state.vcl,
                vcu: this.state.vcu
            };
        console.log('pss2ST => ' + JSON.stringify(pss2ST));

        // step 5
        if(this.state.id === '_add'){
            pss2ST.pss2STId=''
            Pss2STService.createPss2ST(pss2ST).then(res =>{
                this.props.history.push('/pss2STs');
            });
        }else{
            Pss2STService.updatePss2ST(pss2ST).then( res => {
                this.props.history.push('/pss2STs');
            });
        }
    }
    
    changeinputSignal1TypeHandler= (event) => {
        this.setState({inputSignal1Type: event.target.value});
    }
    changeinputSignal2TypeHandler= (event) => {
        this.setState({inputSignal2Type: event.target.value});
    }
    changek1Handler= (event) => {
        this.setState({k1: event.target.value});
    }
    changek2Handler= (event) => {
        this.setState({k2: event.target.value});
    }
    changelsmaxHandler= (event) => {
        this.setState({lsmax: event.target.value});
    }
    changelsminHandler= (event) => {
        this.setState({lsmin: event.target.value});
    }
    changet1Handler= (event) => {
        this.setState({t1: event.target.value});
    }
    changet10Handler= (event) => {
        this.setState({t10: event.target.value});
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
    changet7Handler= (event) => {
        this.setState({t7: event.target.value});
    }
    changet8Handler= (event) => {
        this.setState({t8: event.target.value});
    }
    changet9Handler= (event) => {
        this.setState({t9: event.target.value});
    }
    changevclHandler= (event) => {
        this.setState({vcl: event.target.value});
    }
    changevcuHandler= (event) => {
        this.setState({vcu: event.target.value});
    }

    cancel(){
        this.props.history.push('/pss2STs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Pss2ST</h3>
        }else{
            return <h3 className="text-center">Update Pss2ST</h3>
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
                                            <label> inputSignal1Type: </label>
                                            #formFields( $attribute, 'create')
                                            <label> inputSignal2Type: </label>
                                            #formFields( $attribute, 'create')
                                            <label> k1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> k2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> lsmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> lsmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t10: </label>
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
                                            <label> t7: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t8: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t9: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vcl: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vcu: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePss2ST}>Save</button>
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

export default CreatePss2STComponent
