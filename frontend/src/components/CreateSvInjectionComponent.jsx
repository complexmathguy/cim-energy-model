import React, { Component } from 'react'
import SvInjectionService from '../services/SvInjectionService';

class CreateSvInjectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                pInjection: '',
                qInjection: ''
        }
        this.changepInjectionHandler = this.changepInjectionHandler.bind(this);
        this.changeqInjectionHandler = this.changeqInjectionHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            SvInjectionService.getSvInjectionById(this.state.id).then( (res) =>{
                let svInjection = res.data;
                this.setState({
                    pInjection: svInjection.pInjection,
                    qInjection: svInjection.qInjection
                });
            });
        }        
    }
    saveOrUpdateSvInjection = (e) => {
        e.preventDefault();
        let svInjection = {
                svInjectionId: this.state.id,
                pInjection: this.state.pInjection,
                qInjection: this.state.qInjection
            };
        console.log('svInjection => ' + JSON.stringify(svInjection));

        // step 5
        if(this.state.id === '_add'){
            svInjection.svInjectionId=''
            SvInjectionService.createSvInjection(svInjection).then(res =>{
                this.props.history.push('/svInjections');
            });
        }else{
            SvInjectionService.updateSvInjection(svInjection).then( res => {
                this.props.history.push('/svInjections');
            });
        }
    }
    
    changepInjectionHandler= (event) => {
        this.setState({pInjection: event.target.value});
    }
    changeqInjectionHandler= (event) => {
        this.setState({qInjection: event.target.value});
    }

    cancel(){
        this.props.history.push('/svInjections');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SvInjection</h3>
        }else{
            return <h3 className="text-center">Update SvInjection</h3>
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
                                            <label> pInjection: </label>
                                            #formFields( $attribute, 'create')
                                            <label> qInjection: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSvInjection}>Save</button>
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

export default CreateSvInjectionComponent
