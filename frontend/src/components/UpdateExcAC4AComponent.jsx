import React, { Component } from 'react'
import ExcAC4AService from '../services/ExcAC4AService';

class UpdateExcAC4AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                ka: '',
                kc: '',
                ta: '',
                tb: '',
                tc: '',
                vimax: '',
                vimin: '',
                vrmax: '',
                vrmin: ''
        }
        this.updateExcAC4A = this.updateExcAC4A.bind(this);

        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changevimaxHandler = this.changevimaxHandler.bind(this);
        this.changeviminHandler = this.changeviminHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    componentDidMount(){
        ExcAC4AService.getExcAC4AById(this.state.id).then( (res) =>{
            let excAC4A = res.data;
            this.setState({
                ka: excAC4A.ka,
                kc: excAC4A.kc,
                ta: excAC4A.ta,
                tb: excAC4A.tb,
                tc: excAC4A.tc,
                vimax: excAC4A.vimax,
                vimin: excAC4A.vimin,
                vrmax: excAC4A.vrmax,
                vrmin: excAC4A.vrmin
            });
        });
    }

    updateExcAC4A = (e) => {
        e.preventDefault();
        let excAC4A = {
            excAC4AId: this.state.id,
            ka: this.state.ka,
            kc: this.state.kc,
            ta: this.state.ta,
            tb: this.state.tb,
            tc: this.state.tc,
            vimax: this.state.vimax,
            vimin: this.state.vimin,
            vrmax: this.state.vrmax,
            vrmin: this.state.vrmin
        };
        console.log('excAC4A => ' + JSON.stringify(excAC4A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAC4AService.updateExcAC4A(excAC4A).then( res => {
            this.props.history.push('/excAC4As');
        });
    }

    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changekcHandler= (event) => {
        this.setState({kc: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changevimaxHandler= (event) => {
        this.setState({vimax: event.target.value});
    }
    changeviminHandler= (event) => {
        this.setState({vimin: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excAC4As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAC4A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> ka: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vimax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vimin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAC4A}>Save</button>
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

export default UpdateExcAC4AComponent
