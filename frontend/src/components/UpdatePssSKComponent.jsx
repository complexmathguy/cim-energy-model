import React, { Component } from 'react'
import PssSKService from '../services/PssSKService';

class UpdatePssSKComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                k1: '',
                k2: '',
                k3: '',
                t1: '',
                t2: '',
                t3: '',
                t4: '',
                t5: '',
                t6: '',
                vsmax: '',
                vsmin: ''
        }
        this.updatePssSK = this.updatePssSK.bind(this);

        this.changek1Handler = this.changek1Handler.bind(this);
        this.changek2Handler = this.changek2Handler.bind(this);
        this.changek3Handler = this.changek3Handler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changet5Handler = this.changet5Handler.bind(this);
        this.changet6Handler = this.changet6Handler.bind(this);
        this.changevsmaxHandler = this.changevsmaxHandler.bind(this);
        this.changevsminHandler = this.changevsminHandler.bind(this);
    }

    componentDidMount(){
        PssSKService.getPssSKById(this.state.id).then( (res) =>{
            let pssSK = res.data;
            this.setState({
                k1: pssSK.k1,
                k2: pssSK.k2,
                k3: pssSK.k3,
                t1: pssSK.t1,
                t2: pssSK.t2,
                t3: pssSK.t3,
                t4: pssSK.t4,
                t5: pssSK.t5,
                t6: pssSK.t6,
                vsmax: pssSK.vsmax,
                vsmin: pssSK.vsmin
            });
        });
    }

    updatePssSK = (e) => {
        e.preventDefault();
        let pssSK = {
            pssSKId: this.state.id,
            k1: this.state.k1,
            k2: this.state.k2,
            k3: this.state.k3,
            t1: this.state.t1,
            t2: this.state.t2,
            t3: this.state.t3,
            t4: this.state.t4,
            t5: this.state.t5,
            t6: this.state.t6,
            vsmax: this.state.vsmax,
            vsmin: this.state.vsmin
        };
        console.log('pssSK => ' + JSON.stringify(pssSK));
        console.log('id => ' + JSON.stringify(this.state.id));
        PssSKService.updatePssSK(pssSK).then( res => {
            this.props.history.push('/pssSKs');
        });
    }

    changek1Handler= (event) => {
        this.setState({k1: event.target.value});
    }
    changek2Handler= (event) => {
        this.setState({k2: event.target.value});
    }
    changek3Handler= (event) => {
        this.setState({k3: event.target.value});
    }
    changet1Handler= (event) => {
        this.setState({t1: event.target.value});
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
    changet5Handler= (event) => {
        this.setState({t5: event.target.value});
    }
    changet6Handler= (event) => {
        this.setState({t6: event.target.value});
    }
    changevsmaxHandler= (event) => {
        this.setState({vsmax: event.target.value});
    }
    changevsminHandler= (event) => {
        this.setState({vsmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/pssSKs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PssSK</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> k1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t6: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vsmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vsmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePssSK}>Save</button>
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

export default UpdatePssSKComponent
