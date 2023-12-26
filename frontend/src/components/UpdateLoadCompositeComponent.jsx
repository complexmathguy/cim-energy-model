import React, { Component } from 'react'
import LoadCompositeService from '../services/LoadCompositeService';

class UpdateLoadCompositeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                epfd: '',
                epfs: '',
                epvd: '',
                epvs: '',
                eqfd: '',
                eqfs: '',
                eqvd: '',
                eqvs: '',
                h: '',
                lfrac: '',
                pfrac: ''
        }
        this.updateLoadComposite = this.updateLoadComposite.bind(this);

        this.changeepfdHandler = this.changeepfdHandler.bind(this);
        this.changeepfsHandler = this.changeepfsHandler.bind(this);
        this.changeepvdHandler = this.changeepvdHandler.bind(this);
        this.changeepvsHandler = this.changeepvsHandler.bind(this);
        this.changeeqfdHandler = this.changeeqfdHandler.bind(this);
        this.changeeqfsHandler = this.changeeqfsHandler.bind(this);
        this.changeeqvdHandler = this.changeeqvdHandler.bind(this);
        this.changeeqvsHandler = this.changeeqvsHandler.bind(this);
        this.changehHandler = this.changehHandler.bind(this);
        this.changelfracHandler = this.changelfracHandler.bind(this);
        this.changepfracHandler = this.changepfracHandler.bind(this);
    }

    componentDidMount(){
        LoadCompositeService.getLoadCompositeById(this.state.id).then( (res) =>{
            let loadComposite = res.data;
            this.setState({
                epfd: loadComposite.epfd,
                epfs: loadComposite.epfs,
                epvd: loadComposite.epvd,
                epvs: loadComposite.epvs,
                eqfd: loadComposite.eqfd,
                eqfs: loadComposite.eqfs,
                eqvd: loadComposite.eqvd,
                eqvs: loadComposite.eqvs,
                h: loadComposite.h,
                lfrac: loadComposite.lfrac,
                pfrac: loadComposite.pfrac
            });
        });
    }

    updateLoadComposite = (e) => {
        e.preventDefault();
        let loadComposite = {
            loadCompositeId: this.state.id,
            epfd: this.state.epfd,
            epfs: this.state.epfs,
            epvd: this.state.epvd,
            epvs: this.state.epvs,
            eqfd: this.state.eqfd,
            eqfs: this.state.eqfs,
            eqvd: this.state.eqvd,
            eqvs: this.state.eqvs,
            h: this.state.h,
            lfrac: this.state.lfrac,
            pfrac: this.state.pfrac
        };
        console.log('loadComposite => ' + JSON.stringify(loadComposite));
        console.log('id => ' + JSON.stringify(this.state.id));
        LoadCompositeService.updateLoadComposite(loadComposite).then( res => {
            this.props.history.push('/loadComposites');
        });
    }

    changeepfdHandler= (event) => {
        this.setState({epfd: event.target.value});
    }
    changeepfsHandler= (event) => {
        this.setState({epfs: event.target.value});
    }
    changeepvdHandler= (event) => {
        this.setState({epvd: event.target.value});
    }
    changeepvsHandler= (event) => {
        this.setState({epvs: event.target.value});
    }
    changeeqfdHandler= (event) => {
        this.setState({eqfd: event.target.value});
    }
    changeeqfsHandler= (event) => {
        this.setState({eqfs: event.target.value});
    }
    changeeqvdHandler= (event) => {
        this.setState({eqvd: event.target.value});
    }
    changeeqvsHandler= (event) => {
        this.setState({eqvs: event.target.value});
    }
    changehHandler= (event) => {
        this.setState({h: event.target.value});
    }
    changelfracHandler= (event) => {
        this.setState({lfrac: event.target.value});
    }
    changepfracHandler= (event) => {
        this.setState({pfrac: event.target.value});
    }

    cancel(){
        this.props.history.push('/loadComposites');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update LoadComposite</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> epfd: </label>
                                            #formFields( $attribute, 'update')
                                            <label> epfs: </label>
                                            #formFields( $attribute, 'update')
                                            <label> epvd: </label>
                                            #formFields( $attribute, 'update')
                                            <label> epvs: </label>
                                            #formFields( $attribute, 'update')
                                            <label> eqfd: </label>
                                            #formFields( $attribute, 'update')
                                            <label> eqfs: </label>
                                            #formFields( $attribute, 'update')
                                            <label> eqvd: </label>
                                            #formFields( $attribute, 'update')
                                            <label> eqvs: </label>
                                            #formFields( $attribute, 'update')
                                            <label> h: </label>
                                            #formFields( $attribute, 'update')
                                            <label> lfrac: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pfrac: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLoadComposite}>Save</button>
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

export default UpdateLoadCompositeComponent
