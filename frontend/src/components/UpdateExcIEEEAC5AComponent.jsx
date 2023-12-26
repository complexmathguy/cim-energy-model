import React, { Component } from 'react'
import ExcIEEEAC5AService from '../services/ExcIEEEAC5AService';

class UpdateExcIEEEAC5AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                efd1: '',
                efd2: '',
                ka: '',
                ke: '',
                kf: '',
                seefd1: '',
                seefd2: '',
                ta: '',
                te: '',
                tf1: '',
                tf2: '',
                tf3: '',
                vrmax: '',
                vrmin: ''
        }
        this.updateExcIEEEAC5A = this.updateExcIEEEAC5A.bind(this);

        this.changeefd1Handler = this.changeefd1Handler.bind(this);
        this.changeefd2Handler = this.changeefd2Handler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changeseefd1Handler = this.changeseefd1Handler.bind(this);
        this.changeseefd2Handler = this.changeseefd2Handler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetf1Handler = this.changetf1Handler.bind(this);
        this.changetf2Handler = this.changetf2Handler.bind(this);
        this.changetf3Handler = this.changetf3Handler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    componentDidMount(){
        ExcIEEEAC5AService.getExcIEEEAC5AById(this.state.id).then( (res) =>{
            let excIEEEAC5A = res.data;
            this.setState({
                efd1: excIEEEAC5A.efd1,
                efd2: excIEEEAC5A.efd2,
                ka: excIEEEAC5A.ka,
                ke: excIEEEAC5A.ke,
                kf: excIEEEAC5A.kf,
                seefd1: excIEEEAC5A.seefd1,
                seefd2: excIEEEAC5A.seefd2,
                ta: excIEEEAC5A.ta,
                te: excIEEEAC5A.te,
                tf1: excIEEEAC5A.tf1,
                tf2: excIEEEAC5A.tf2,
                tf3: excIEEEAC5A.tf3,
                vrmax: excIEEEAC5A.vrmax,
                vrmin: excIEEEAC5A.vrmin
            });
        });
    }

    updateExcIEEEAC5A = (e) => {
        e.preventDefault();
        let excIEEEAC5A = {
            excIEEEAC5AId: this.state.id,
            efd1: this.state.efd1,
            efd2: this.state.efd2,
            ka: this.state.ka,
            ke: this.state.ke,
            kf: this.state.kf,
            seefd1: this.state.seefd1,
            seefd2: this.state.seefd2,
            ta: this.state.ta,
            te: this.state.te,
            tf1: this.state.tf1,
            tf2: this.state.tf2,
            tf3: this.state.tf3,
            vrmax: this.state.vrmax,
            vrmin: this.state.vrmin
        };
        console.log('excIEEEAC5A => ' + JSON.stringify(excIEEEAC5A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEAC5AService.updateExcIEEEAC5A(excIEEEAC5A).then( res => {
            this.props.history.push('/excIEEEAC5As');
        });
    }

    changeefd1Handler= (event) => {
        this.setState({efd1: event.target.value});
    }
    changeefd2Handler= (event) => {
        this.setState({efd2: event.target.value});
    }
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changekeHandler= (event) => {
        this.setState({ke: event.target.value});
    }
    changekfHandler= (event) => {
        this.setState({kf: event.target.value});
    }
    changeseefd1Handler= (event) => {
        this.setState({seefd1: event.target.value});
    }
    changeseefd2Handler= (event) => {
        this.setState({seefd2: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }
    changetf1Handler= (event) => {
        this.setState({tf1: event.target.value});
    }
    changetf2Handler= (event) => {
        this.setState({tf2: event.target.value});
    }
    changetf3Handler= (event) => {
        this.setState({tf3: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excIEEEAC5As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEAC5A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> efd1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> efd2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ka: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> seefd1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> seefd2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'update')
                                            <label> te: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tf1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tf2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tf3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEAC5A}>Save</button>
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

export default UpdateExcIEEEAC5AComponent
