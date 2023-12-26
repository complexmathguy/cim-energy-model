import React, { Component } from 'react'
import PssIEEE3BService from '../services/PssIEEE3BService';

class CreatePssIEEE3BComponent extends Component {
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
                inputSignal1Type: '',
                inputSignal2Type: '',
                ks1: '',
                ks2: '',
                t1: '',
                t2: '',
                tw1: '',
                tw2: '',
                tw3: '',
                vstmax: '',
                vstmin: ''
        }
        this.changea1Handler = this.changea1Handler.bind(this);
        this.changea2Handler = this.changea2Handler.bind(this);
        this.changea3Handler = this.changea3Handler.bind(this);
        this.changea4Handler = this.changea4Handler.bind(this);
        this.changea5Handler = this.changea5Handler.bind(this);
        this.changea6Handler = this.changea6Handler.bind(this);
        this.changea7Handler = this.changea7Handler.bind(this);
        this.changea8Handler = this.changea8Handler.bind(this);
        this.changeinputSignal1TypeHandler = this.changeinputSignal1TypeHandler.bind(this);
        this.changeinputSignal2TypeHandler = this.changeinputSignal2TypeHandler.bind(this);
        this.changeks1Handler = this.changeks1Handler.bind(this);
        this.changeks2Handler = this.changeks2Handler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changetw1Handler = this.changetw1Handler.bind(this);
        this.changetw2Handler = this.changetw2Handler.bind(this);
        this.changetw3Handler = this.changetw3Handler.bind(this);
        this.changevstmaxHandler = this.changevstmaxHandler.bind(this);
        this.changevstminHandler = this.changevstminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PssIEEE3BService.getPssIEEE3BById(this.state.id).then( (res) =>{
                let pssIEEE3B = res.data;
                this.setState({
                    a1: pssIEEE3B.a1,
                    a2: pssIEEE3B.a2,
                    a3: pssIEEE3B.a3,
                    a4: pssIEEE3B.a4,
                    a5: pssIEEE3B.a5,
                    a6: pssIEEE3B.a6,
                    a7: pssIEEE3B.a7,
                    a8: pssIEEE3B.a8,
                    inputSignal1Type: pssIEEE3B.inputSignal1Type,
                    inputSignal2Type: pssIEEE3B.inputSignal2Type,
                    ks1: pssIEEE3B.ks1,
                    ks2: pssIEEE3B.ks2,
                    t1: pssIEEE3B.t1,
                    t2: pssIEEE3B.t2,
                    tw1: pssIEEE3B.tw1,
                    tw2: pssIEEE3B.tw2,
                    tw3: pssIEEE3B.tw3,
                    vstmax: pssIEEE3B.vstmax,
                    vstmin: pssIEEE3B.vstmin
                });
            });
        }        
    }
    saveOrUpdatePssIEEE3B = (e) => {
        e.preventDefault();
        let pssIEEE3B = {
                pssIEEE3BId: this.state.id,
                a1: this.state.a1,
                a2: this.state.a2,
                a3: this.state.a3,
                a4: this.state.a4,
                a5: this.state.a5,
                a6: this.state.a6,
                a7: this.state.a7,
                a8: this.state.a8,
                inputSignal1Type: this.state.inputSignal1Type,
                inputSignal2Type: this.state.inputSignal2Type,
                ks1: this.state.ks1,
                ks2: this.state.ks2,
                t1: this.state.t1,
                t2: this.state.t2,
                tw1: this.state.tw1,
                tw2: this.state.tw2,
                tw3: this.state.tw3,
                vstmax: this.state.vstmax,
                vstmin: this.state.vstmin
            };
        console.log('pssIEEE3B => ' + JSON.stringify(pssIEEE3B));

        // step 5
        if(this.state.id === '_add'){
            pssIEEE3B.pssIEEE3BId=''
            PssIEEE3BService.createPssIEEE3B(pssIEEE3B).then(res =>{
                this.props.history.push('/pssIEEE3Bs');
            });
        }else{
            PssIEEE3BService.updatePssIEEE3B(pssIEEE3B).then( res => {
                this.props.history.push('/pssIEEE3Bs');
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
    changet1Handler= (event) => {
        this.setState({t1: event.target.value});
    }
    changet2Handler= (event) => {
        this.setState({t2: event.target.value});
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
    changevstmaxHandler= (event) => {
        this.setState({vstmax: event.target.value});
    }
    changevstminHandler= (event) => {
        this.setState({vstmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/pssIEEE3Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PssIEEE3B</h3>
        }else{
            return <h3 className="text-center">Update PssIEEE3B</h3>
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
                                            <label> inputSignal1Type: </label>
                                            #formFields( $attribute, 'create')
                                            <label> inputSignal2Type: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ks1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ks2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tw1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tw2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tw3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vstmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vstmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePssIEEE3B}>Save</button>
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

export default CreatePssIEEE3BComponent
