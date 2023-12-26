import React, { Component } from 'react'
import UnderexcLimX2Service from '../services/UnderexcLimX2Service';

class UpdateUnderexcLimX2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                kf2: '',
                km: '',
                melmax: '',
                qo: '',
                r: '',
                tf2: '',
                tm: ''
        }
        this.updateUnderexcLimX2 = this.updateUnderexcLimX2.bind(this);

        this.changekf2Handler = this.changekf2Handler.bind(this);
        this.changekmHandler = this.changekmHandler.bind(this);
        this.changemelmaxHandler = this.changemelmaxHandler.bind(this);
        this.changeqoHandler = this.changeqoHandler.bind(this);
        this.changerHandler = this.changerHandler.bind(this);
        this.changetf2Handler = this.changetf2Handler.bind(this);
        this.changetmHandler = this.changetmHandler.bind(this);
    }

    componentDidMount(){
        UnderexcLimX2Service.getUnderexcLimX2ById(this.state.id).then( (res) =>{
            let underexcLimX2 = res.data;
            this.setState({
                kf2: underexcLimX2.kf2,
                km: underexcLimX2.km,
                melmax: underexcLimX2.melmax,
                qo: underexcLimX2.qo,
                r: underexcLimX2.r,
                tf2: underexcLimX2.tf2,
                tm: underexcLimX2.tm
            });
        });
    }

    updateUnderexcLimX2 = (e) => {
        e.preventDefault();
        let underexcLimX2 = {
            underexcLimX2Id: this.state.id,
            kf2: this.state.kf2,
            km: this.state.km,
            melmax: this.state.melmax,
            qo: this.state.qo,
            r: this.state.r,
            tf2: this.state.tf2,
            tm: this.state.tm
        };
        console.log('underexcLimX2 => ' + JSON.stringify(underexcLimX2));
        console.log('id => ' + JSON.stringify(this.state.id));
        UnderexcLimX2Service.updateUnderexcLimX2(underexcLimX2).then( res => {
            this.props.history.push('/underexcLimX2s');
        });
    }

    changekf2Handler= (event) => {
        this.setState({kf2: event.target.value});
    }
    changekmHandler= (event) => {
        this.setState({km: event.target.value});
    }
    changemelmaxHandler= (event) => {
        this.setState({melmax: event.target.value});
    }
    changeqoHandler= (event) => {
        this.setState({qo: event.target.value});
    }
    changerHandler= (event) => {
        this.setState({r: event.target.value});
    }
    changetf2Handler= (event) => {
        this.setState({tf2: event.target.value});
    }
    changetmHandler= (event) => {
        this.setState({tm: event.target.value});
    }

    cancel(){
        this.props.history.push('/underexcLimX2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update UnderexcLimX2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> kf2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> km: </label>
                                            #formFields( $attribute, 'update')
                                            <label> melmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> qo: </label>
                                            #formFields( $attribute, 'update')
                                            <label> r: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tf2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tm: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateUnderexcLimX2}>Save</button>
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

export default UpdateUnderexcLimX2Component
