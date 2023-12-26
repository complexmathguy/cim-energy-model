import React, { Component } from 'react'
import PssWECCService from '../services/PssWECCService';

class CreatePssWECCComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                inputSignal1Type: '',
                inputSignal2Type: '',
                k1: '',
                k2: '',
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
                vcu: '',
                vsmax: '',
                vsmin: ''
        }
        this.changeinputSignal1TypeHandler = this.changeinputSignal1TypeHandler.bind(this);
        this.changeinputSignal2TypeHandler = this.changeinputSignal2TypeHandler.bind(this);
        this.changek1Handler = this.changek1Handler.bind(this);
        this.changek2Handler = this.changek2Handler.bind(this);
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
        this.changevsmaxHandler = this.changevsmaxHandler.bind(this);
        this.changevsminHandler = this.changevsminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PssWECCService.getPssWECCById(this.state.id).then( (res) =>{
                let pssWECC = res.data;
                this.setState({
                    inputSignal1Type: pssWECC.inputSignal1Type,
                    inputSignal2Type: pssWECC.inputSignal2Type,
                    k1: pssWECC.k1,
                    k2: pssWECC.k2,
                    t1: pssWECC.t1,
                    t10: pssWECC.t10,
                    t2: pssWECC.t2,
                    t3: pssWECC.t3,
                    t4: pssWECC.t4,
                    t5: pssWECC.t5,
                    t6: pssWECC.t6,
                    t7: pssWECC.t7,
                    t8: pssWECC.t8,
                    t9: pssWECC.t9,
                    vcl: pssWECC.vcl,
                    vcu: pssWECC.vcu,
                    vsmax: pssWECC.vsmax,
                    vsmin: pssWECC.vsmin
                });
            });
        }        
    }
    saveOrUpdatePssWECC = (e) => {
        e.preventDefault();
        let pssWECC = {
                pssWECCId: this.state.id,
                inputSignal1Type: this.state.inputSignal1Type,
                inputSignal2Type: this.state.inputSignal2Type,
                k1: this.state.k1,
                k2: this.state.k2,
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
                vcu: this.state.vcu,
                vsmax: this.state.vsmax,
                vsmin: this.state.vsmin
            };
        console.log('pssWECC => ' + JSON.stringify(pssWECC));

        // step 5
        if(this.state.id === '_add'){
            pssWECC.pssWECCId=''
            PssWECCService.createPssWECC(pssWECC).then(res =>{
                this.props.history.push('/pssWECCs');
            });
        }else{
            PssWECCService.updatePssWECC(pssWECC).then( res => {
                this.props.history.push('/pssWECCs');
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
    changevsmaxHandler= (event) => {
        this.setState({vsmax: event.target.value});
    }
    changevsminHandler= (event) => {
        this.setState({vsmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/pssWECCs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PssWECC</h3>
        }else{
            return <h3 className="text-center">Update PssWECC</h3>
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
                                            <label> vsmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vsmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePssWECC}>Save</button>
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

export default CreatePssWECCComponent
