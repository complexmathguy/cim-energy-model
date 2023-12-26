import React, { Component } from 'react'
import GovGAST4Service from '../services/GovGAST4Service';

class UpdateGovGAST4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
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
        this.updateGovGAST4 = this.updateGovGAST4.bind(this);

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

    componentDidMount(){
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

    updateGovGAST4 = (e) => {
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
        console.log('id => ' + JSON.stringify(this.state.id));
        GovGAST4Service.updateGovGAST4(govGAST4).then( res => {
            this.props.history.push('/govGAST4s');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovGAST4</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> bp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ktm: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mnef: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mxef: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rymn: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rymx: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tcm: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tm: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tv: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovGAST4}>Save</button>
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

export default UpdateGovGAST4Component
