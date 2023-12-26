import React, { Component } from 'react'
import LoadCompositeService from '../services/LoadCompositeService';

class CreateLoadCompositeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
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

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
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
    }
    saveOrUpdateLoadComposite = (e) => {
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

        // step 5
        if(this.state.id === '_add'){
            loadComposite.loadCompositeId=''
            LoadCompositeService.createLoadComposite(loadComposite).then(res =>{
                this.props.history.push('/loadComposites');
            });
        }else{
            LoadCompositeService.updateLoadComposite(loadComposite).then( res => {
                this.props.history.push('/loadComposites');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add LoadComposite</h3>
        }else{
            return <h3 className="text-center">Update LoadComposite</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> epfd: </label>
                                            #formFields( $attribute, 'create')
                                            <label> epfs: </label>
                                            #formFields( $attribute, 'create')
                                            <label> epvd: </label>
                                            #formFields( $attribute, 'create')
                                            <label> epvs: </label>
                                            #formFields( $attribute, 'create')
                                            <label> eqfd: </label>
                                            #formFields( $attribute, 'create')
                                            <label> eqfs: </label>
                                            #formFields( $attribute, 'create')
                                            <label> eqvd: </label>
                                            #formFields( $attribute, 'create')
                                            <label> eqvs: </label>
                                            #formFields( $attribute, 'create')
                                            <label> h: </label>
                                            #formFields( $attribute, 'create')
                                            <label> lfrac: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pfrac: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateLoadComposite}>Save</button>
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

export default CreateLoadCompositeComponent
