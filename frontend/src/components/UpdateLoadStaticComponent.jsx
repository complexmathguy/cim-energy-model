import React, { Component } from 'react'
import LoadStaticService from '../services/LoadStaticService';

class UpdateLoadStaticComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                ep1: '',
                ep2: '',
                ep3: '',
                eq1: '',
                eq2: '',
                eq3: '',
                kp1: '',
                kp2: '',
                kp3: '',
                kp4: '',
                kpf: '',
                kq1: '',
                kq2: '',
                kq3: '',
                kq4: '',
                kqf: '',
                staticLoadModelType: ''
        }
        this.updateLoadStatic = this.updateLoadStatic.bind(this);

        this.changeep1Handler = this.changeep1Handler.bind(this);
        this.changeep2Handler = this.changeep2Handler.bind(this);
        this.changeep3Handler = this.changeep3Handler.bind(this);
        this.changeeq1Handler = this.changeeq1Handler.bind(this);
        this.changeeq2Handler = this.changeeq2Handler.bind(this);
        this.changeeq3Handler = this.changeeq3Handler.bind(this);
        this.changekp1Handler = this.changekp1Handler.bind(this);
        this.changekp2Handler = this.changekp2Handler.bind(this);
        this.changekp3Handler = this.changekp3Handler.bind(this);
        this.changekp4Handler = this.changekp4Handler.bind(this);
        this.changekpfHandler = this.changekpfHandler.bind(this);
        this.changekq1Handler = this.changekq1Handler.bind(this);
        this.changekq2Handler = this.changekq2Handler.bind(this);
        this.changekq3Handler = this.changekq3Handler.bind(this);
        this.changekq4Handler = this.changekq4Handler.bind(this);
        this.changekqfHandler = this.changekqfHandler.bind(this);
        this.changestaticLoadModelTypeHandler = this.changestaticLoadModelTypeHandler.bind(this);
    }

    componentDidMount(){
        LoadStaticService.getLoadStaticById(this.state.id).then( (res) =>{
            let loadStatic = res.data;
            this.setState({
                ep1: loadStatic.ep1,
                ep2: loadStatic.ep2,
                ep3: loadStatic.ep3,
                eq1: loadStatic.eq1,
                eq2: loadStatic.eq2,
                eq3: loadStatic.eq3,
                kp1: loadStatic.kp1,
                kp2: loadStatic.kp2,
                kp3: loadStatic.kp3,
                kp4: loadStatic.kp4,
                kpf: loadStatic.kpf,
                kq1: loadStatic.kq1,
                kq2: loadStatic.kq2,
                kq3: loadStatic.kq3,
                kq4: loadStatic.kq4,
                kqf: loadStatic.kqf,
                staticLoadModelType: loadStatic.staticLoadModelType
            });
        });
    }

    updateLoadStatic = (e) => {
        e.preventDefault();
        let loadStatic = {
            loadStaticId: this.state.id,
            ep1: this.state.ep1,
            ep2: this.state.ep2,
            ep3: this.state.ep3,
            eq1: this.state.eq1,
            eq2: this.state.eq2,
            eq3: this.state.eq3,
            kp1: this.state.kp1,
            kp2: this.state.kp2,
            kp3: this.state.kp3,
            kp4: this.state.kp4,
            kpf: this.state.kpf,
            kq1: this.state.kq1,
            kq2: this.state.kq2,
            kq3: this.state.kq3,
            kq4: this.state.kq4,
            kqf: this.state.kqf,
            staticLoadModelType: this.state.staticLoadModelType
        };
        console.log('loadStatic => ' + JSON.stringify(loadStatic));
        console.log('id => ' + JSON.stringify(this.state.id));
        LoadStaticService.updateLoadStatic(loadStatic).then( res => {
            this.props.history.push('/loadStatics');
        });
    }

    changeep1Handler= (event) => {
        this.setState({ep1: event.target.value});
    }
    changeep2Handler= (event) => {
        this.setState({ep2: event.target.value});
    }
    changeep3Handler= (event) => {
        this.setState({ep3: event.target.value});
    }
    changeeq1Handler= (event) => {
        this.setState({eq1: event.target.value});
    }
    changeeq2Handler= (event) => {
        this.setState({eq2: event.target.value});
    }
    changeeq3Handler= (event) => {
        this.setState({eq3: event.target.value});
    }
    changekp1Handler= (event) => {
        this.setState({kp1: event.target.value});
    }
    changekp2Handler= (event) => {
        this.setState({kp2: event.target.value});
    }
    changekp3Handler= (event) => {
        this.setState({kp3: event.target.value});
    }
    changekp4Handler= (event) => {
        this.setState({kp4: event.target.value});
    }
    changekpfHandler= (event) => {
        this.setState({kpf: event.target.value});
    }
    changekq1Handler= (event) => {
        this.setState({kq1: event.target.value});
    }
    changekq2Handler= (event) => {
        this.setState({kq2: event.target.value});
    }
    changekq3Handler= (event) => {
        this.setState({kq3: event.target.value});
    }
    changekq4Handler= (event) => {
        this.setState({kq4: event.target.value});
    }
    changekqfHandler= (event) => {
        this.setState({kqf: event.target.value});
    }
    changestaticLoadModelTypeHandler= (event) => {
        this.setState({staticLoadModelType: event.target.value});
    }

    cancel(){
        this.props.history.push('/loadStatics');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update LoadStatic</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> ep1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ep2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ep3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> eq1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> eq2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> eq3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kp1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kp2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kp3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kp4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kpf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kq1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kq2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kq3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kq4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kqf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> staticLoadModelType: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLoadStatic}>Save</button>
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

export default UpdateLoadStaticComponent
