import React, { Component } from 'react'
import GovHydro1Service from '../services/GovHydro1Service';

class UpdateGovHydro1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                at: '',
                dturb: '',
                gmax: '',
                gmin: '',
                hdam: '',
                mwbase: '',
                qnl: '',
                rperm: '',
                rtemp: '',
                tf: '',
                tg: '',
                tr: '',
                tw: '',
                velm: ''
        }
        this.updateGovHydro1 = this.updateGovHydro1.bind(this);

        this.changeatHandler = this.changeatHandler.bind(this);
        this.changedturbHandler = this.changedturbHandler.bind(this);
        this.changegmaxHandler = this.changegmaxHandler.bind(this);
        this.changegminHandler = this.changegminHandler.bind(this);
        this.changehdamHandler = this.changehdamHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changeqnlHandler = this.changeqnlHandler.bind(this);
        this.changerpermHandler = this.changerpermHandler.bind(this);
        this.changertempHandler = this.changertempHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changetgHandler = this.changetgHandler.bind(this);
        this.changetrHandler = this.changetrHandler.bind(this);
        this.changetwHandler = this.changetwHandler.bind(this);
        this.changevelmHandler = this.changevelmHandler.bind(this);
    }

    componentDidMount(){
        GovHydro1Service.getGovHydro1ById(this.state.id).then( (res) =>{
            let govHydro1 = res.data;
            this.setState({
                at: govHydro1.at,
                dturb: govHydro1.dturb,
                gmax: govHydro1.gmax,
                gmin: govHydro1.gmin,
                hdam: govHydro1.hdam,
                mwbase: govHydro1.mwbase,
                qnl: govHydro1.qnl,
                rperm: govHydro1.rperm,
                rtemp: govHydro1.rtemp,
                tf: govHydro1.tf,
                tg: govHydro1.tg,
                tr: govHydro1.tr,
                tw: govHydro1.tw,
                velm: govHydro1.velm
            });
        });
    }

    updateGovHydro1 = (e) => {
        e.preventDefault();
        let govHydro1 = {
            govHydro1Id: this.state.id,
            at: this.state.at,
            dturb: this.state.dturb,
            gmax: this.state.gmax,
            gmin: this.state.gmin,
            hdam: this.state.hdam,
            mwbase: this.state.mwbase,
            qnl: this.state.qnl,
            rperm: this.state.rperm,
            rtemp: this.state.rtemp,
            tf: this.state.tf,
            tg: this.state.tg,
            tr: this.state.tr,
            tw: this.state.tw,
            velm: this.state.velm
        };
        console.log('govHydro1 => ' + JSON.stringify(govHydro1));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydro1Service.updateGovHydro1(govHydro1).then( res => {
            this.props.history.push('/govHydro1s');
        });
    }

    changeatHandler= (event) => {
        this.setState({at: event.target.value});
    }
    changedturbHandler= (event) => {
        this.setState({dturb: event.target.value});
    }
    changegmaxHandler= (event) => {
        this.setState({gmax: event.target.value});
    }
    changegminHandler= (event) => {
        this.setState({gmin: event.target.value});
    }
    changehdamHandler= (event) => {
        this.setState({hdam: event.target.value});
    }
    changemwbaseHandler= (event) => {
        this.setState({mwbase: event.target.value});
    }
    changeqnlHandler= (event) => {
        this.setState({qnl: event.target.value});
    }
    changerpermHandler= (event) => {
        this.setState({rperm: event.target.value});
    }
    changertempHandler= (event) => {
        this.setState({rtemp: event.target.value});
    }
    changetfHandler= (event) => {
        this.setState({tf: event.target.value});
    }
    changetgHandler= (event) => {
        this.setState({tg: event.target.value});
    }
    changetrHandler= (event) => {
        this.setState({tr: event.target.value});
    }
    changetwHandler= (event) => {
        this.setState({tw: event.target.value});
    }
    changevelmHandler= (event) => {
        this.setState({velm: event.target.value});
    }

    cancel(){
        this.props.history.push('/govHydro1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydro1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> at: </label>
                                            #formFields( $attribute, 'update')
                                            <label> dturb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> hdam: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'update')
                                            <label> qnl: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rperm: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rtemp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tg: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tr: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tw: </label>
                                            #formFields( $attribute, 'update')
                                            <label> velm: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovHydro1}>Save</button>
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

export default UpdateGovHydro1Component
