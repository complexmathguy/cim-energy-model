import React, { Component } from 'react'
import Pss2BService from '../services/Pss2BService';

class UpdatePss2BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                a: '',
                inputSignal1Type: '',
                inputSignal2Type: '',
                ks1: '',
                ks2: '',
                ks3: '',
                ks4: '',
                m: '',
                n: '',
                t1: '',
                t10: '',
                t11: '',
                t2: '',
                t3: '',
                t4: '',
                t6: '',
                t7: '',
                t8: '',
                t9: '',
                ta: '',
                tb: '',
                tw1: '',
                tw2: '',
                tw3: '',
                tw4: '',
                vsi1max: '',
                vsi1min: '',
                vsi2max: '',
                vsi2min: '',
                vstmax: '',
                vstmin: ''
        }
        this.updatePss2B = this.updatePss2B.bind(this);

        this.changeaHandler = this.changeaHandler.bind(this);
        this.changeinputSignal1TypeHandler = this.changeinputSignal1TypeHandler.bind(this);
        this.changeinputSignal2TypeHandler = this.changeinputSignal2TypeHandler.bind(this);
        this.changeks1Handler = this.changeks1Handler.bind(this);
        this.changeks2Handler = this.changeks2Handler.bind(this);
        this.changeks3Handler = this.changeks3Handler.bind(this);
        this.changeks4Handler = this.changeks4Handler.bind(this);
        this.changemHandler = this.changemHandler.bind(this);
        this.changenHandler = this.changenHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet10Handler = this.changet10Handler.bind(this);
        this.changet11Handler = this.changet11Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changet6Handler = this.changet6Handler.bind(this);
        this.changet7Handler = this.changet7Handler.bind(this);
        this.changet8Handler = this.changet8Handler.bind(this);
        this.changet9Handler = this.changet9Handler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetw1Handler = this.changetw1Handler.bind(this);
        this.changetw2Handler = this.changetw2Handler.bind(this);
        this.changetw3Handler = this.changetw3Handler.bind(this);
        this.changetw4Handler = this.changetw4Handler.bind(this);
        this.changevsi1maxHandler = this.changevsi1maxHandler.bind(this);
        this.changevsi1minHandler = this.changevsi1minHandler.bind(this);
        this.changevsi2maxHandler = this.changevsi2maxHandler.bind(this);
        this.changevsi2minHandler = this.changevsi2minHandler.bind(this);
        this.changevstmaxHandler = this.changevstmaxHandler.bind(this);
        this.changevstminHandler = this.changevstminHandler.bind(this);
    }

    componentDidMount(){
        Pss2BService.getPss2BById(this.state.id).then( (res) =>{
            let pss2B = res.data;
            this.setState({
                a: pss2B.a,
                inputSignal1Type: pss2B.inputSignal1Type,
                inputSignal2Type: pss2B.inputSignal2Type,
                ks1: pss2B.ks1,
                ks2: pss2B.ks2,
                ks3: pss2B.ks3,
                ks4: pss2B.ks4,
                m: pss2B.m,
                n: pss2B.n,
                t1: pss2B.t1,
                t10: pss2B.t10,
                t11: pss2B.t11,
                t2: pss2B.t2,
                t3: pss2B.t3,
                t4: pss2B.t4,
                t6: pss2B.t6,
                t7: pss2B.t7,
                t8: pss2B.t8,
                t9: pss2B.t9,
                ta: pss2B.ta,
                tb: pss2B.tb,
                tw1: pss2B.tw1,
                tw2: pss2B.tw2,
                tw3: pss2B.tw3,
                tw4: pss2B.tw4,
                vsi1max: pss2B.vsi1max,
                vsi1min: pss2B.vsi1min,
                vsi2max: pss2B.vsi2max,
                vsi2min: pss2B.vsi2min,
                vstmax: pss2B.vstmax,
                vstmin: pss2B.vstmin
            });
        });
    }

    updatePss2B = (e) => {
        e.preventDefault();
        let pss2B = {
            pss2BId: this.state.id,
            a: this.state.a,
            inputSignal1Type: this.state.inputSignal1Type,
            inputSignal2Type: this.state.inputSignal2Type,
            ks1: this.state.ks1,
            ks2: this.state.ks2,
            ks3: this.state.ks3,
            ks4: this.state.ks4,
            m: this.state.m,
            n: this.state.n,
            t1: this.state.t1,
            t10: this.state.t10,
            t11: this.state.t11,
            t2: this.state.t2,
            t3: this.state.t3,
            t4: this.state.t4,
            t6: this.state.t6,
            t7: this.state.t7,
            t8: this.state.t8,
            t9: this.state.t9,
            ta: this.state.ta,
            tb: this.state.tb,
            tw1: this.state.tw1,
            tw2: this.state.tw2,
            tw3: this.state.tw3,
            tw4: this.state.tw4,
            vsi1max: this.state.vsi1max,
            vsi1min: this.state.vsi1min,
            vsi2max: this.state.vsi2max,
            vsi2min: this.state.vsi2min,
            vstmax: this.state.vstmax,
            vstmin: this.state.vstmin
        };
        console.log('pss2B => ' + JSON.stringify(pss2B));
        console.log('id => ' + JSON.stringify(this.state.id));
        Pss2BService.updatePss2B(pss2B).then( res => {
            this.props.history.push('/pss2Bs');
        });
    }

    changeaHandler= (event) => {
        this.setState({a: event.target.value});
    }
    changeinputSignal1TypeHandler= (event) => {
        this.setState({inputSignal1Type: event.target.value});
    }
    changeinputSignal2TypeHandler= (event) => {
        this.setState({inputSignal2Type: event.target.value});
    }
    changeks1Handler= (event) => {
        this.setState({ks1: event.target.value});
    }
    changeks2Handler= (event) => {
        this.setState({ks2: event.target.value});
    }
    changeks3Handler= (event) => {
        this.setState({ks3: event.target.value});
    }
    changeks4Handler= (event) => {
        this.setState({ks4: event.target.value});
    }
    changemHandler= (event) => {
        this.setState({m: event.target.value});
    }
    changenHandler= (event) => {
        this.setState({n: event.target.value});
    }
    changet1Handler= (event) => {
        this.setState({t1: event.target.value});
    }
    changet10Handler= (event) => {
        this.setState({t10: event.target.value});
    }
    changet11Handler= (event) => {
        this.setState({t11: event.target.value});
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
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changetw1Handler= (event) => {
        this.setState({tw1: event.target.value});
    }
    changetw2Handler= (event) => {
        this.setState({tw2: event.target.value});
    }
    changetw3Handler= (event) => {
        this.setState({tw3: event.target.value});
    }
    changetw4Handler= (event) => {
        this.setState({tw4: event.target.value});
    }
    changevsi1maxHandler= (event) => {
        this.setState({vsi1max: event.target.value});
    }
    changevsi1minHandler= (event) => {
        this.setState({vsi1min: event.target.value});
    }
    changevsi2maxHandler= (event) => {
        this.setState({vsi2max: event.target.value});
    }
    changevsi2minHandler= (event) => {
        this.setState({vsi2min: event.target.value});
    }
    changevstmaxHandler= (event) => {
        this.setState({vstmax: event.target.value});
    }
    changevstminHandler= (event) => {
        this.setState({vstmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/pss2Bs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Pss2B</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> a: </label>
                                            #formFields( $attribute, 'update')
                                            <label> inputSignal1Type: </label>
                                            #formFields( $attribute, 'update')
                                            <label> inputSignal2Type: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ks1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ks2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ks3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ks4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> m: </label>
                                            #formFields( $attribute, 'update')
                                            <label> n: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t10: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t11: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t6: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t7: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t8: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t9: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tw1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tw2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tw3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tw4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vsi1max: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vsi1min: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vsi2max: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vsi2min: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vstmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vstmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePss2B}>Save</button>
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

export default UpdatePss2BComponent
