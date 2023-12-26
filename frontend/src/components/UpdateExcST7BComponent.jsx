import React, { Component } from 'react'
import ExcST7BService from '../services/ExcST7BService';

class UpdateExcST7BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                kh: '',
                kia: '',
                kl: '',
                kpa: '',
                oelin: '',
                tb: '',
                tc: '',
                tf: '',
                tg: '',
                tia: '',
                ts: '',
                uelin: '',
                vmax: '',
                vmin: '',
                vrmax: '',
                vrmin: ''
        }
        this.updateExcST7B = this.updateExcST7B.bind(this);

        this.changekhHandler = this.changekhHandler.bind(this);
        this.changekiaHandler = this.changekiaHandler.bind(this);
        this.changeklHandler = this.changeklHandler.bind(this);
        this.changekpaHandler = this.changekpaHandler.bind(this);
        this.changeoelinHandler = this.changeoelinHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changetgHandler = this.changetgHandler.bind(this);
        this.changetiaHandler = this.changetiaHandler.bind(this);
        this.changetsHandler = this.changetsHandler.bind(this);
        this.changeuelinHandler = this.changeuelinHandler.bind(this);
        this.changevmaxHandler = this.changevmaxHandler.bind(this);
        this.changevminHandler = this.changevminHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    componentDidMount(){
        ExcST7BService.getExcST7BById(this.state.id).then( (res) =>{
            let excST7B = res.data;
            this.setState({
                kh: excST7B.kh,
                kia: excST7B.kia,
                kl: excST7B.kl,
                kpa: excST7B.kpa,
                oelin: excST7B.oelin,
                tb: excST7B.tb,
                tc: excST7B.tc,
                tf: excST7B.tf,
                tg: excST7B.tg,
                tia: excST7B.tia,
                ts: excST7B.ts,
                uelin: excST7B.uelin,
                vmax: excST7B.vmax,
                vmin: excST7B.vmin,
                vrmax: excST7B.vrmax,
                vrmin: excST7B.vrmin
            });
        });
    }

    updateExcST7B = (e) => {
        e.preventDefault();
        let excST7B = {
            excST7BId: this.state.id,
            kh: this.state.kh,
            kia: this.state.kia,
            kl: this.state.kl,
            kpa: this.state.kpa,
            oelin: this.state.oelin,
            tb: this.state.tb,
            tc: this.state.tc,
            tf: this.state.tf,
            tg: this.state.tg,
            tia: this.state.tia,
            ts: this.state.ts,
            uelin: this.state.uelin,
            vmax: this.state.vmax,
            vmin: this.state.vmin,
            vrmax: this.state.vrmax,
            vrmin: this.state.vrmin
        };
        console.log('excST7B => ' + JSON.stringify(excST7B));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcST7BService.updateExcST7B(excST7B).then( res => {
            this.props.history.push('/excST7Bs');
        });
    }

    changekhHandler= (event) => {
        this.setState({kh: event.target.value});
    }
    changekiaHandler= (event) => {
        this.setState({kia: event.target.value});
    }
    changeklHandler= (event) => {
        this.setState({kl: event.target.value});
    }
    changekpaHandler= (event) => {
        this.setState({kpa: event.target.value});
    }
    changeoelinHandler= (event) => {
        this.setState({oelin: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changetfHandler= (event) => {
        this.setState({tf: event.target.value});
    }
    changetgHandler= (event) => {
        this.setState({tg: event.target.value});
    }
    changetiaHandler= (event) => {
        this.setState({tia: event.target.value});
    }
    changetsHandler= (event) => {
        this.setState({ts: event.target.value});
    }
    changeuelinHandler= (event) => {
        this.setState({uelin: event.target.value});
    }
    changevmaxHandler= (event) => {
        this.setState({vmax: event.target.value});
    }
    changevminHandler= (event) => {
        this.setState({vmin: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excST7Bs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcST7B</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> kh: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kia: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kl: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kpa: </label>
                                            #formFields( $attribute, 'update')
                                            <label> oelin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tg: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tia: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ts: </label>
                                            #formFields( $attribute, 'update')
                                            <label> uelin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcST7B}>Save</button>
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

export default UpdateExcST7BComponent
