import React, { Component } from 'react'
import ExcAVR7Service from '../services/ExcAVR7Service';

class UpdateExcAVR7Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                a1: '',
                a2: '',
                a3: '',
                a4: '',
                a5: '',
                a6: '',
                k1: '',
                k3: '',
                k5: '',
                t1: '',
                t2: '',
                t3: '',
                t4: '',
                t5: '',
                t6: '',
                vmax1: '',
                vmax3: '',
                vmax5: '',
                vmin1: '',
                vmin3: '',
                vmin5: ''
        }
        this.updateExcAVR7 = this.updateExcAVR7.bind(this);

        this.changea1Handler = this.changea1Handler.bind(this);
        this.changea2Handler = this.changea2Handler.bind(this);
        this.changea3Handler = this.changea3Handler.bind(this);
        this.changea4Handler = this.changea4Handler.bind(this);
        this.changea5Handler = this.changea5Handler.bind(this);
        this.changea6Handler = this.changea6Handler.bind(this);
        this.changek1Handler = this.changek1Handler.bind(this);
        this.changek3Handler = this.changek3Handler.bind(this);
        this.changek5Handler = this.changek5Handler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changet5Handler = this.changet5Handler.bind(this);
        this.changet6Handler = this.changet6Handler.bind(this);
        this.changevmax1Handler = this.changevmax1Handler.bind(this);
        this.changevmax3Handler = this.changevmax3Handler.bind(this);
        this.changevmax5Handler = this.changevmax5Handler.bind(this);
        this.changevmin1Handler = this.changevmin1Handler.bind(this);
        this.changevmin3Handler = this.changevmin3Handler.bind(this);
        this.changevmin5Handler = this.changevmin5Handler.bind(this);
    }

    componentDidMount(){
        ExcAVR7Service.getExcAVR7ById(this.state.id).then( (res) =>{
            let excAVR7 = res.data;
            this.setState({
                a1: excAVR7.a1,
                a2: excAVR7.a2,
                a3: excAVR7.a3,
                a4: excAVR7.a4,
                a5: excAVR7.a5,
                a6: excAVR7.a6,
                k1: excAVR7.k1,
                k3: excAVR7.k3,
                k5: excAVR7.k5,
                t1: excAVR7.t1,
                t2: excAVR7.t2,
                t3: excAVR7.t3,
                t4: excAVR7.t4,
                t5: excAVR7.t5,
                t6: excAVR7.t6,
                vmax1: excAVR7.vmax1,
                vmax3: excAVR7.vmax3,
                vmax5: excAVR7.vmax5,
                vmin1: excAVR7.vmin1,
                vmin3: excAVR7.vmin3,
                vmin5: excAVR7.vmin5
            });
        });
    }

    updateExcAVR7 = (e) => {
        e.preventDefault();
        let excAVR7 = {
            excAVR7Id: this.state.id,
            a1: this.state.a1,
            a2: this.state.a2,
            a3: this.state.a3,
            a4: this.state.a4,
            a5: this.state.a5,
            a6: this.state.a6,
            k1: this.state.k1,
            k3: this.state.k3,
            k5: this.state.k5,
            t1: this.state.t1,
            t2: this.state.t2,
            t3: this.state.t3,
            t4: this.state.t4,
            t5: this.state.t5,
            t6: this.state.t6,
            vmax1: this.state.vmax1,
            vmax3: this.state.vmax3,
            vmax5: this.state.vmax5,
            vmin1: this.state.vmin1,
            vmin3: this.state.vmin3,
            vmin5: this.state.vmin5
        };
        console.log('excAVR7 => ' + JSON.stringify(excAVR7));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAVR7Service.updateExcAVR7(excAVR7).then( res => {
            this.props.history.push('/excAVR7s');
        });
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
    changek1Handler= (event) => {
        this.setState({k1: event.target.value});
    }
    changek3Handler= (event) => {
        this.setState({k3: event.target.value});
    }
    changek5Handler= (event) => {
        this.setState({k5: event.target.value});
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
    changevmax1Handler= (event) => {
        this.setState({vmax1: event.target.value});
    }
    changevmax3Handler= (event) => {
        this.setState({vmax3: event.target.value});
    }
    changevmax5Handler= (event) => {
        this.setState({vmax5: event.target.value});
    }
    changevmin1Handler= (event) => {
        this.setState({vmin1: event.target.value});
    }
    changevmin3Handler= (event) => {
        this.setState({vmin3: event.target.value});
    }
    changevmin5Handler= (event) => {
        this.setState({vmin5: event.target.value});
    }

    cancel(){
        this.props.history.push('/excAVR7s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAVR7</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> a1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> a2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> a3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> a4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> a5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> a6: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k5: </label>
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
                                            <label> vmax1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vmax3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vmax5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vmin1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vmin3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vmin5: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAVR7}>Save</button>
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

export default UpdateExcAVR7Component
