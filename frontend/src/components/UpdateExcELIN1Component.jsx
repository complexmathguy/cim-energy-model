import React, { Component } from 'react'
import ExcELIN1Service from '../services/ExcELIN1Service';

class UpdateExcELIN1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                dpnf: '',
                efmax: '',
                efmin: '',
                ks1: '',
                ks2: '',
                smax: '',
                tfi: '',
                tnu: '',
                ts1: '',
                ts2: '',
                tsw: '',
                vpi: '',
                vpnf: '',
                vpu: '',
                xe: ''
        }
        this.updateExcELIN1 = this.updateExcELIN1.bind(this);

        this.changedpnfHandler = this.changedpnfHandler.bind(this);
        this.changeefmaxHandler = this.changeefmaxHandler.bind(this);
        this.changeefminHandler = this.changeefminHandler.bind(this);
        this.changeks1Handler = this.changeks1Handler.bind(this);
        this.changeks2Handler = this.changeks2Handler.bind(this);
        this.changesmaxHandler = this.changesmaxHandler.bind(this);
        this.changetfiHandler = this.changetfiHandler.bind(this);
        this.changetnuHandler = this.changetnuHandler.bind(this);
        this.changets1Handler = this.changets1Handler.bind(this);
        this.changets2Handler = this.changets2Handler.bind(this);
        this.changetswHandler = this.changetswHandler.bind(this);
        this.changevpiHandler = this.changevpiHandler.bind(this);
        this.changevpnfHandler = this.changevpnfHandler.bind(this);
        this.changevpuHandler = this.changevpuHandler.bind(this);
        this.changexeHandler = this.changexeHandler.bind(this);
    }

    componentDidMount(){
        ExcELIN1Service.getExcELIN1ById(this.state.id).then( (res) =>{
            let excELIN1 = res.data;
            this.setState({
                dpnf: excELIN1.dpnf,
                efmax: excELIN1.efmax,
                efmin: excELIN1.efmin,
                ks1: excELIN1.ks1,
                ks2: excELIN1.ks2,
                smax: excELIN1.smax,
                tfi: excELIN1.tfi,
                tnu: excELIN1.tnu,
                ts1: excELIN1.ts1,
                ts2: excELIN1.ts2,
                tsw: excELIN1.tsw,
                vpi: excELIN1.vpi,
                vpnf: excELIN1.vpnf,
                vpu: excELIN1.vpu,
                xe: excELIN1.xe
            });
        });
    }

    updateExcELIN1 = (e) => {
        e.preventDefault();
        let excELIN1 = {
            excELIN1Id: this.state.id,
            dpnf: this.state.dpnf,
            efmax: this.state.efmax,
            efmin: this.state.efmin,
            ks1: this.state.ks1,
            ks2: this.state.ks2,
            smax: this.state.smax,
            tfi: this.state.tfi,
            tnu: this.state.tnu,
            ts1: this.state.ts1,
            ts2: this.state.ts2,
            tsw: this.state.tsw,
            vpi: this.state.vpi,
            vpnf: this.state.vpnf,
            vpu: this.state.vpu,
            xe: this.state.xe
        };
        console.log('excELIN1 => ' + JSON.stringify(excELIN1));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcELIN1Service.updateExcELIN1(excELIN1).then( res => {
            this.props.history.push('/excELIN1s');
        });
    }

    changedpnfHandler= (event) => {
        this.setState({dpnf: event.target.value});
    }
    changeefmaxHandler= (event) => {
        this.setState({efmax: event.target.value});
    }
    changeefminHandler= (event) => {
        this.setState({efmin: event.target.value});
    }
    changeks1Handler= (event) => {
        this.setState({ks1: event.target.value});
    }
    changeks2Handler= (event) => {
        this.setState({ks2: event.target.value});
    }
    changesmaxHandler= (event) => {
        this.setState({smax: event.target.value});
    }
    changetfiHandler= (event) => {
        this.setState({tfi: event.target.value});
    }
    changetnuHandler= (event) => {
        this.setState({tnu: event.target.value});
    }
    changets1Handler= (event) => {
        this.setState({ts1: event.target.value});
    }
    changets2Handler= (event) => {
        this.setState({ts2: event.target.value});
    }
    changetswHandler= (event) => {
        this.setState({tsw: event.target.value});
    }
    changevpiHandler= (event) => {
        this.setState({vpi: event.target.value});
    }
    changevpnfHandler= (event) => {
        this.setState({vpnf: event.target.value});
    }
    changevpuHandler= (event) => {
        this.setState({vpu: event.target.value});
    }
    changexeHandler= (event) => {
        this.setState({xe: event.target.value});
    }

    cancel(){
        this.props.history.push('/excELIN1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcELIN1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> dpnf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> efmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> efmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ks1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ks2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> smax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tfi: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tnu: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ts1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ts2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tsw: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vpi: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vpnf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vpu: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xe: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcELIN1}>Save</button>
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

export default UpdateExcELIN1Component
