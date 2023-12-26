import React, { Component } from 'react'
import PssIEEE4BService from '../services/PssIEEE4BService';

class CreatePssIEEE4BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                bwh1: '',
                bwh2: '',
                bwl1: '',
                bwl2: '',
                kh: '',
                kh1: '',
                kh11: '',
                kh17: '',
                kh2: '',
                ki: '',
                ki1: '',
                ki11: '',
                ki17: '',
                ki2: '',
                kl: '',
                kl1: '',
                kl11: '',
                kl17: '',
                kl2: '',
                omeganh1: '',
                omeganh2: '',
                omeganl1: '',
                omeganl2: '',
                th1: '',
                th10: '',
                th11: '',
                th12: '',
                th2: '',
                th3: '',
                th4: '',
                th5: '',
                th6: '',
                th7: '',
                th8: '',
                th9: '',
                ti1: '',
                ti10: '',
                ti11: '',
                ti12: '',
                ti2: '',
                ti3: '',
                ti4: '',
                ti5: '',
                ti6: '',
                ti7: '',
                ti8: '',
                ti9: '',
                tl1: '',
                tl10: '',
                tl11: '',
                tl12: '',
                tl2: '',
                tl3: '',
                tl4: '',
                tl5: '',
                tl6: '',
                tl7: '',
                tl8: '',
                tl9: '',
                vhmax: '',
                vhmin: '',
                vimax: '',
                vimin: '',
                vlmax: '',
                vlmin: '',
                vstmax: '',
                vstmin: ''
        }
        this.changebwh1Handler = this.changebwh1Handler.bind(this);
        this.changebwh2Handler = this.changebwh2Handler.bind(this);
        this.changebwl1Handler = this.changebwl1Handler.bind(this);
        this.changebwl2Handler = this.changebwl2Handler.bind(this);
        this.changekhHandler = this.changekhHandler.bind(this);
        this.changekh1Handler = this.changekh1Handler.bind(this);
        this.changekh11Handler = this.changekh11Handler.bind(this);
        this.changekh17Handler = this.changekh17Handler.bind(this);
        this.changekh2Handler = this.changekh2Handler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changeki1Handler = this.changeki1Handler.bind(this);
        this.changeki11Handler = this.changeki11Handler.bind(this);
        this.changeki17Handler = this.changeki17Handler.bind(this);
        this.changeki2Handler = this.changeki2Handler.bind(this);
        this.changeklHandler = this.changeklHandler.bind(this);
        this.changekl1Handler = this.changekl1Handler.bind(this);
        this.changekl11Handler = this.changekl11Handler.bind(this);
        this.changekl17Handler = this.changekl17Handler.bind(this);
        this.changekl2Handler = this.changekl2Handler.bind(this);
        this.changeomeganh1Handler = this.changeomeganh1Handler.bind(this);
        this.changeomeganh2Handler = this.changeomeganh2Handler.bind(this);
        this.changeomeganl1Handler = this.changeomeganl1Handler.bind(this);
        this.changeomeganl2Handler = this.changeomeganl2Handler.bind(this);
        this.changeth1Handler = this.changeth1Handler.bind(this);
        this.changeth10Handler = this.changeth10Handler.bind(this);
        this.changeth11Handler = this.changeth11Handler.bind(this);
        this.changeth12Handler = this.changeth12Handler.bind(this);
        this.changeth2Handler = this.changeth2Handler.bind(this);
        this.changeth3Handler = this.changeth3Handler.bind(this);
        this.changeth4Handler = this.changeth4Handler.bind(this);
        this.changeth5Handler = this.changeth5Handler.bind(this);
        this.changeth6Handler = this.changeth6Handler.bind(this);
        this.changeth7Handler = this.changeth7Handler.bind(this);
        this.changeth8Handler = this.changeth8Handler.bind(this);
        this.changeth9Handler = this.changeth9Handler.bind(this);
        this.changeti1Handler = this.changeti1Handler.bind(this);
        this.changeti10Handler = this.changeti10Handler.bind(this);
        this.changeti11Handler = this.changeti11Handler.bind(this);
        this.changeti12Handler = this.changeti12Handler.bind(this);
        this.changeti2Handler = this.changeti2Handler.bind(this);
        this.changeti3Handler = this.changeti3Handler.bind(this);
        this.changeti4Handler = this.changeti4Handler.bind(this);
        this.changeti5Handler = this.changeti5Handler.bind(this);
        this.changeti6Handler = this.changeti6Handler.bind(this);
        this.changeti7Handler = this.changeti7Handler.bind(this);
        this.changeti8Handler = this.changeti8Handler.bind(this);
        this.changeti9Handler = this.changeti9Handler.bind(this);
        this.changetl1Handler = this.changetl1Handler.bind(this);
        this.changetl10Handler = this.changetl10Handler.bind(this);
        this.changetl11Handler = this.changetl11Handler.bind(this);
        this.changetl12Handler = this.changetl12Handler.bind(this);
        this.changetl2Handler = this.changetl2Handler.bind(this);
        this.changetl3Handler = this.changetl3Handler.bind(this);
        this.changetl4Handler = this.changetl4Handler.bind(this);
        this.changetl5Handler = this.changetl5Handler.bind(this);
        this.changetl6Handler = this.changetl6Handler.bind(this);
        this.changetl7Handler = this.changetl7Handler.bind(this);
        this.changetl8Handler = this.changetl8Handler.bind(this);
        this.changetl9Handler = this.changetl9Handler.bind(this);
        this.changevhmaxHandler = this.changevhmaxHandler.bind(this);
        this.changevhminHandler = this.changevhminHandler.bind(this);
        this.changevimaxHandler = this.changevimaxHandler.bind(this);
        this.changeviminHandler = this.changeviminHandler.bind(this);
        this.changevlmaxHandler = this.changevlmaxHandler.bind(this);
        this.changevlminHandler = this.changevlminHandler.bind(this);
        this.changevstmaxHandler = this.changevstmaxHandler.bind(this);
        this.changevstminHandler = this.changevstminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PssIEEE4BService.getPssIEEE4BById(this.state.id).then( (res) =>{
                let pssIEEE4B = res.data;
                this.setState({
                    bwh1: pssIEEE4B.bwh1,
                    bwh2: pssIEEE4B.bwh2,
                    bwl1: pssIEEE4B.bwl1,
                    bwl2: pssIEEE4B.bwl2,
                    kh: pssIEEE4B.kh,
                    kh1: pssIEEE4B.kh1,
                    kh11: pssIEEE4B.kh11,
                    kh17: pssIEEE4B.kh17,
                    kh2: pssIEEE4B.kh2,
                    ki: pssIEEE4B.ki,
                    ki1: pssIEEE4B.ki1,
                    ki11: pssIEEE4B.ki11,
                    ki17: pssIEEE4B.ki17,
                    ki2: pssIEEE4B.ki2,
                    kl: pssIEEE4B.kl,
                    kl1: pssIEEE4B.kl1,
                    kl11: pssIEEE4B.kl11,
                    kl17: pssIEEE4B.kl17,
                    kl2: pssIEEE4B.kl2,
                    omeganh1: pssIEEE4B.omeganh1,
                    omeganh2: pssIEEE4B.omeganh2,
                    omeganl1: pssIEEE4B.omeganl1,
                    omeganl2: pssIEEE4B.omeganl2,
                    th1: pssIEEE4B.th1,
                    th10: pssIEEE4B.th10,
                    th11: pssIEEE4B.th11,
                    th12: pssIEEE4B.th12,
                    th2: pssIEEE4B.th2,
                    th3: pssIEEE4B.th3,
                    th4: pssIEEE4B.th4,
                    th5: pssIEEE4B.th5,
                    th6: pssIEEE4B.th6,
                    th7: pssIEEE4B.th7,
                    th8: pssIEEE4B.th8,
                    th9: pssIEEE4B.th9,
                    ti1: pssIEEE4B.ti1,
                    ti10: pssIEEE4B.ti10,
                    ti11: pssIEEE4B.ti11,
                    ti12: pssIEEE4B.ti12,
                    ti2: pssIEEE4B.ti2,
                    ti3: pssIEEE4B.ti3,
                    ti4: pssIEEE4B.ti4,
                    ti5: pssIEEE4B.ti5,
                    ti6: pssIEEE4B.ti6,
                    ti7: pssIEEE4B.ti7,
                    ti8: pssIEEE4B.ti8,
                    ti9: pssIEEE4B.ti9,
                    tl1: pssIEEE4B.tl1,
                    tl10: pssIEEE4B.tl10,
                    tl11: pssIEEE4B.tl11,
                    tl12: pssIEEE4B.tl12,
                    tl2: pssIEEE4B.tl2,
                    tl3: pssIEEE4B.tl3,
                    tl4: pssIEEE4B.tl4,
                    tl5: pssIEEE4B.tl5,
                    tl6: pssIEEE4B.tl6,
                    tl7: pssIEEE4B.tl7,
                    tl8: pssIEEE4B.tl8,
                    tl9: pssIEEE4B.tl9,
                    vhmax: pssIEEE4B.vhmax,
                    vhmin: pssIEEE4B.vhmin,
                    vimax: pssIEEE4B.vimax,
                    vimin: pssIEEE4B.vimin,
                    vlmax: pssIEEE4B.vlmax,
                    vlmin: pssIEEE4B.vlmin,
                    vstmax: pssIEEE4B.vstmax,
                    vstmin: pssIEEE4B.vstmin
                });
            });
        }        
    }
    saveOrUpdatePssIEEE4B = (e) => {
        e.preventDefault();
        let pssIEEE4B = {
                pssIEEE4BId: this.state.id,
                bwh1: this.state.bwh1,
                bwh2: this.state.bwh2,
                bwl1: this.state.bwl1,
                bwl2: this.state.bwl2,
                kh: this.state.kh,
                kh1: this.state.kh1,
                kh11: this.state.kh11,
                kh17: this.state.kh17,
                kh2: this.state.kh2,
                ki: this.state.ki,
                ki1: this.state.ki1,
                ki11: this.state.ki11,
                ki17: this.state.ki17,
                ki2: this.state.ki2,
                kl: this.state.kl,
                kl1: this.state.kl1,
                kl11: this.state.kl11,
                kl17: this.state.kl17,
                kl2: this.state.kl2,
                omeganh1: this.state.omeganh1,
                omeganh2: this.state.omeganh2,
                omeganl1: this.state.omeganl1,
                omeganl2: this.state.omeganl2,
                th1: this.state.th1,
                th10: this.state.th10,
                th11: this.state.th11,
                th12: this.state.th12,
                th2: this.state.th2,
                th3: this.state.th3,
                th4: this.state.th4,
                th5: this.state.th5,
                th6: this.state.th6,
                th7: this.state.th7,
                th8: this.state.th8,
                th9: this.state.th9,
                ti1: this.state.ti1,
                ti10: this.state.ti10,
                ti11: this.state.ti11,
                ti12: this.state.ti12,
                ti2: this.state.ti2,
                ti3: this.state.ti3,
                ti4: this.state.ti4,
                ti5: this.state.ti5,
                ti6: this.state.ti6,
                ti7: this.state.ti7,
                ti8: this.state.ti8,
                ti9: this.state.ti9,
                tl1: this.state.tl1,
                tl10: this.state.tl10,
                tl11: this.state.tl11,
                tl12: this.state.tl12,
                tl2: this.state.tl2,
                tl3: this.state.tl3,
                tl4: this.state.tl4,
                tl5: this.state.tl5,
                tl6: this.state.tl6,
                tl7: this.state.tl7,
                tl8: this.state.tl8,
                tl9: this.state.tl9,
                vhmax: this.state.vhmax,
                vhmin: this.state.vhmin,
                vimax: this.state.vimax,
                vimin: this.state.vimin,
                vlmax: this.state.vlmax,
                vlmin: this.state.vlmin,
                vstmax: this.state.vstmax,
                vstmin: this.state.vstmin
            };
        console.log('pssIEEE4B => ' + JSON.stringify(pssIEEE4B));

        // step 5
        if(this.state.id === '_add'){
            pssIEEE4B.pssIEEE4BId=''
            PssIEEE4BService.createPssIEEE4B(pssIEEE4B).then(res =>{
                this.props.history.push('/pssIEEE4Bs');
            });
        }else{
            PssIEEE4BService.updatePssIEEE4B(pssIEEE4B).then( res => {
                this.props.history.push('/pssIEEE4Bs');
            });
        }
    }
    
    changebwh1Handler= (event) => {
        this.setState({bwh1: event.target.value});
    }
    changebwh2Handler= (event) => {
        this.setState({bwh2: event.target.value});
    }
    changebwl1Handler= (event) => {
        this.setState({bwl1: event.target.value});
    }
    changebwl2Handler= (event) => {
        this.setState({bwl2: event.target.value});
    }
    changekhHandler= (event) => {
        this.setState({kh: event.target.value});
    }
    changekh1Handler= (event) => {
        this.setState({kh1: event.target.value});
    }
    changekh11Handler= (event) => {
        this.setState({kh11: event.target.value});
    }
    changekh17Handler= (event) => {
        this.setState({kh17: event.target.value});
    }
    changekh2Handler= (event) => {
        this.setState({kh2: event.target.value});
    }
    changekiHandler= (event) => {
        this.setState({ki: event.target.value});
    }
    changeki1Handler= (event) => {
        this.setState({ki1: event.target.value});
    }
    changeki11Handler= (event) => {
        this.setState({ki11: event.target.value});
    }
    changeki17Handler= (event) => {
        this.setState({ki17: event.target.value});
    }
    changeki2Handler= (event) => {
        this.setState({ki2: event.target.value});
    }
    changeklHandler= (event) => {
        this.setState({kl: event.target.value});
    }
    changekl1Handler= (event) => {
        this.setState({kl1: event.target.value});
    }
    changekl11Handler= (event) => {
        this.setState({kl11: event.target.value});
    }
    changekl17Handler= (event) => {
        this.setState({kl17: event.target.value});
    }
    changekl2Handler= (event) => {
        this.setState({kl2: event.target.value});
    }
    changeomeganh1Handler= (event) => {
        this.setState({omeganh1: event.target.value});
    }
    changeomeganh2Handler= (event) => {
        this.setState({omeganh2: event.target.value});
    }
    changeomeganl1Handler= (event) => {
        this.setState({omeganl1: event.target.value});
    }
    changeomeganl2Handler= (event) => {
        this.setState({omeganl2: event.target.value});
    }
    changeth1Handler= (event) => {
        this.setState({th1: event.target.value});
    }
    changeth10Handler= (event) => {
        this.setState({th10: event.target.value});
    }
    changeth11Handler= (event) => {
        this.setState({th11: event.target.value});
    }
    changeth12Handler= (event) => {
        this.setState({th12: event.target.value});
    }
    changeth2Handler= (event) => {
        this.setState({th2: event.target.value});
    }
    changeth3Handler= (event) => {
        this.setState({th3: event.target.value});
    }
    changeth4Handler= (event) => {
        this.setState({th4: event.target.value});
    }
    changeth5Handler= (event) => {
        this.setState({th5: event.target.value});
    }
    changeth6Handler= (event) => {
        this.setState({th6: event.target.value});
    }
    changeth7Handler= (event) => {
        this.setState({th7: event.target.value});
    }
    changeth8Handler= (event) => {
        this.setState({th8: event.target.value});
    }
    changeth9Handler= (event) => {
        this.setState({th9: event.target.value});
    }
    changeti1Handler= (event) => {
        this.setState({ti1: event.target.value});
    }
    changeti10Handler= (event) => {
        this.setState({ti10: event.target.value});
    }
    changeti11Handler= (event) => {
        this.setState({ti11: event.target.value});
    }
    changeti12Handler= (event) => {
        this.setState({ti12: event.target.value});
    }
    changeti2Handler= (event) => {
        this.setState({ti2: event.target.value});
    }
    changeti3Handler= (event) => {
        this.setState({ti3: event.target.value});
    }
    changeti4Handler= (event) => {
        this.setState({ti4: event.target.value});
    }
    changeti5Handler= (event) => {
        this.setState({ti5: event.target.value});
    }
    changeti6Handler= (event) => {
        this.setState({ti6: event.target.value});
    }
    changeti7Handler= (event) => {
        this.setState({ti7: event.target.value});
    }
    changeti8Handler= (event) => {
        this.setState({ti8: event.target.value});
    }
    changeti9Handler= (event) => {
        this.setState({ti9: event.target.value});
    }
    changetl1Handler= (event) => {
        this.setState({tl1: event.target.value});
    }
    changetl10Handler= (event) => {
        this.setState({tl10: event.target.value});
    }
    changetl11Handler= (event) => {
        this.setState({tl11: event.target.value});
    }
    changetl12Handler= (event) => {
        this.setState({tl12: event.target.value});
    }
    changetl2Handler= (event) => {
        this.setState({tl2: event.target.value});
    }
    changetl3Handler= (event) => {
        this.setState({tl3: event.target.value});
    }
    changetl4Handler= (event) => {
        this.setState({tl4: event.target.value});
    }
    changetl5Handler= (event) => {
        this.setState({tl5: event.target.value});
    }
    changetl6Handler= (event) => {
        this.setState({tl6: event.target.value});
    }
    changetl7Handler= (event) => {
        this.setState({tl7: event.target.value});
    }
    changetl8Handler= (event) => {
        this.setState({tl8: event.target.value});
    }
    changetl9Handler= (event) => {
        this.setState({tl9: event.target.value});
    }
    changevhmaxHandler= (event) => {
        this.setState({vhmax: event.target.value});
    }
    changevhminHandler= (event) => {
        this.setState({vhmin: event.target.value});
    }
    changevimaxHandler= (event) => {
        this.setState({vimax: event.target.value});
    }
    changeviminHandler= (event) => {
        this.setState({vimin: event.target.value});
    }
    changevlmaxHandler= (event) => {
        this.setState({vlmax: event.target.value});
    }
    changevlminHandler= (event) => {
        this.setState({vlmin: event.target.value});
    }
    changevstmaxHandler= (event) => {
        this.setState({vstmax: event.target.value});
    }
    changevstminHandler= (event) => {
        this.setState({vstmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/pssIEEE4Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PssIEEE4B</h3>
        }else{
            return <h3 className="text-center">Update PssIEEE4B</h3>
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
                                            <label> bwh1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> bwh2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> bwl1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> bwl2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kh: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kh1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kh11: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kh17: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kh2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ki1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ki11: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ki17: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ki2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kl: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kl1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kl11: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kl17: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kl2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> omeganh1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> omeganh2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> omeganl1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> omeganl2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> th1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> th10: </label>
                                            #formFields( $attribute, 'create')
                                            <label> th11: </label>
                                            #formFields( $attribute, 'create')
                                            <label> th12: </label>
                                            #formFields( $attribute, 'create')
                                            <label> th2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> th3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> th4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> th5: </label>
                                            #formFields( $attribute, 'create')
                                            <label> th6: </label>
                                            #formFields( $attribute, 'create')
                                            <label> th7: </label>
                                            #formFields( $attribute, 'create')
                                            <label> th8: </label>
                                            #formFields( $attribute, 'create')
                                            <label> th9: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ti1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ti10: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ti11: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ti12: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ti2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ti3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ti4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ti5: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ti6: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ti7: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ti8: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ti9: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tl1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tl10: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tl11: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tl12: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tl2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tl3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tl4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tl5: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tl6: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tl7: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tl8: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tl9: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vhmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vhmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vimax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vimin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vlmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vlmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vstmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vstmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePssIEEE4B}>Save</button>
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

export default CreatePssIEEE4BComponent
