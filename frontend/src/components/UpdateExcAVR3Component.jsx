import React, { Component } from 'react'
import ExcAVR3Service from '../services/ExcAVR3Service';

class UpdateExcAVR3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                e1: '',
                e2: '',
                ka: '',
                se1: '',
                se2: '',
                t1: '',
                t2: '',
                t3: '',
                t4: '',
                te: '',
                vrmn: '',
                vrmx: ''
        }
        this.updateExcAVR3 = this.updateExcAVR3.bind(this);

        this.changee1Handler = this.changee1Handler.bind(this);
        this.changee2Handler = this.changee2Handler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changese1Handler = this.changese1Handler.bind(this);
        this.changese2Handler = this.changese2Handler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changevrmnHandler = this.changevrmnHandler.bind(this);
        this.changevrmxHandler = this.changevrmxHandler.bind(this);
    }

    componentDidMount(){
        ExcAVR3Service.getExcAVR3ById(this.state.id).then( (res) =>{
            let excAVR3 = res.data;
            this.setState({
                e1: excAVR3.e1,
                e2: excAVR3.e2,
                ka: excAVR3.ka,
                se1: excAVR3.se1,
                se2: excAVR3.se2,
                t1: excAVR3.t1,
                t2: excAVR3.t2,
                t3: excAVR3.t3,
                t4: excAVR3.t4,
                te: excAVR3.te,
                vrmn: excAVR3.vrmn,
                vrmx: excAVR3.vrmx
            });
        });
    }

    updateExcAVR3 = (e) => {
        e.preventDefault();
        let excAVR3 = {
            excAVR3Id: this.state.id,
            e1: this.state.e1,
            e2: this.state.e2,
            ka: this.state.ka,
            se1: this.state.se1,
            se2: this.state.se2,
            t1: this.state.t1,
            t2: this.state.t2,
            t3: this.state.t3,
            t4: this.state.t4,
            te: this.state.te,
            vrmn: this.state.vrmn,
            vrmx: this.state.vrmx
        };
        console.log('excAVR3 => ' + JSON.stringify(excAVR3));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAVR3Service.updateExcAVR3(excAVR3).then( res => {
            this.props.history.push('/excAVR3s');
        });
    }

    changee1Handler= (event) => {
        this.setState({e1: event.target.value});
    }
    changee2Handler= (event) => {
        this.setState({e2: event.target.value});
    }
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changese1Handler= (event) => {
        this.setState({se1: event.target.value});
    }
    changese2Handler= (event) => {
        this.setState({se2: event.target.value});
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
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }
    changevrmnHandler= (event) => {
        this.setState({vrmn: event.target.value});
    }
    changevrmxHandler= (event) => {
        this.setState({vrmx: event.target.value});
    }

    cancel(){
        this.props.history.push('/excAVR3s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAVR3</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> e1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> e2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ka: </label>
                                            #formFields( $attribute, 'update')
                                            <label> se1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> se2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> te: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmn: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmx: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAVR3}>Save</button>
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

export default UpdateExcAVR3Component
