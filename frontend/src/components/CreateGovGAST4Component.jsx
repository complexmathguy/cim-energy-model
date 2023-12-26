import React, { Component } from 'react'
import GovGAST4Service from '../services/GovGAST4Service';

class CreateGovGAST4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                bp: '',
                ktm: '',
                mnef: '',
                mxef: '',
                rymn: '',
                rymx: '',
                ta: '',
                tc: '',
                tcm: '',
                tm: '',
                tv: ''
        }
        this.changebpHandler = this.changebpHandler.bind(this);
        this.changektmHandler = this.changektmHandler.bind(this);
        this.changemnefHandler = this.changemnefHandler.bind(this);
        this.changemxefHandler = this.changemxefHandler.bind(this);
        this.changerymnHandler = this.changerymnHandler.bind(this);
        this.changerymxHandler = this.changerymxHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changetcmHandler = this.changetcmHandler.bind(this);
        this.changetmHandler = this.changetmHandler.bind(this);
        this.changetvHandler = this.changetvHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            GovGAST4Service.getGovGAST4ById(this.state.id).then( (res) =>{
                let govGAST4 = res.data;
                this.setState({
                    bp: govGAST4.bp,
                    ktm: govGAST4.ktm,
                    mnef: govGAST4.mnef,
                    mxef: govGAST4.mxef,
                    rymn: govGAST4.rymn,
                    rymx: govGAST4.rymx,
                    ta: govGAST4.ta,
                    tc: govGAST4.tc,
                    tcm: govGAST4.tcm,
                    tm: govGAST4.tm,
                    tv: govGAST4.tv
                });
            });
        }        
    }
    saveOrUpdateGovGAST4 = (e) => {
        e.preventDefault();
        let govGAST4 = {
                govGAST4Id: this.state.id,
                bp: this.state.bp,
                ktm: this.state.ktm,
                mnef: this.state.mnef,
                mxef: this.state.mxef,
                rymn: this.state.rymn,
                rymx: this.state.rymx,
                ta: this.state.ta,
                tc: this.state.tc,
                tcm: this.state.tcm,
                tm: this.state.tm,
                tv: this.state.tv
            };
        console.log('govGAST4 => ' + JSON.stringify(govGAST4));

        // step 5
        if(this.state.id === '_add'){
            govGAST4.govGAST4Id=''
            GovGAST4Service.createGovGAST4(govGAST4).then(res =>{
                this.props.history.push('/govGAST4s');
            });
        }else{
            GovGAST4Service.updateGovGAST4(govGAST4).then( res => {
                this.props.history.push('/govGAST4s');
            });
        }
    }
    
    changebpHandler= (event) => {
        this.setState({bp: event.target.value});
    }
    changektmHandler= (event) => {
        this.setState({ktm: event.target.value});
    }
    changemnefHandler= (event) => {
        this.setState({mnef: event.target.value});
    }
    changemxefHandler= (event) => {
        this.setState({mxef: event.target.value});
    }
    changerymnHandler= (event) => {
        this.setState({rymn: event.target.value});
    }
    changerymxHandler= (event) => {
        this.setState({rymx: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changetcmHandler= (event) => {
        this.setState({tcm: event.target.value});
    }
    changetmHandler= (event) => {
        this.setState({tm: event.target.value});
    }
    changetvHandler= (event) => {
        this.setState({tv: event.target.value});
    }

    cancel(){
        this.props.history.push('/govGAST4s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovGAST4</h3>
        }else{
            return <h3 className="text-center">Update GovGAST4</h3>
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
                                            <label> bp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ktm: </label>
                                            #formFields( $attribute, 'create')
                                            <label> mnef: </label>
                                            #formFields( $attribute, 'create')
                                            <label> mxef: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rymn: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rymx: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tcm: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tm: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tv: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovGAST4}>Save</button>
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

export default CreateGovGAST4Component
