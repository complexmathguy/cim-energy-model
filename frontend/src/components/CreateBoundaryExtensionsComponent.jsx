import React, { Component } from 'react'
import BoundaryExtensionsService from '../services/BoundaryExtensionsService';

class CreateBoundaryExtensionsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                boundaryPoint: '',
                fromEndIsoCode: '',
                fromEndName: '',
                fromEndNameTso: '',
                toEndIsoCode: '',
                toEndName: '',
                toEndNameTso: ''
        }
        this.changeboundaryPointHandler = this.changeboundaryPointHandler.bind(this);
        this.changefromEndIsoCodeHandler = this.changefromEndIsoCodeHandler.bind(this);
        this.changefromEndNameHandler = this.changefromEndNameHandler.bind(this);
        this.changefromEndNameTsoHandler = this.changefromEndNameTsoHandler.bind(this);
        this.changetoEndIsoCodeHandler = this.changetoEndIsoCodeHandler.bind(this);
        this.changetoEndNameHandler = this.changetoEndNameHandler.bind(this);
        this.changetoEndNameTsoHandler = this.changetoEndNameTsoHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            BoundaryExtensionsService.getBoundaryExtensionsById(this.state.id).then( (res) =>{
                let boundaryExtensions = res.data;
                this.setState({
                    boundaryPoint: boundaryExtensions.boundaryPoint,
                    fromEndIsoCode: boundaryExtensions.fromEndIsoCode,
                    fromEndName: boundaryExtensions.fromEndName,
                    fromEndNameTso: boundaryExtensions.fromEndNameTso,
                    toEndIsoCode: boundaryExtensions.toEndIsoCode,
                    toEndName: boundaryExtensions.toEndName,
                    toEndNameTso: boundaryExtensions.toEndNameTso
                });
            });
        }        
    }
    saveOrUpdateBoundaryExtensions = (e) => {
        e.preventDefault();
        let boundaryExtensions = {
                boundaryExtensionsId: this.state.id,
                boundaryPoint: this.state.boundaryPoint,
                fromEndIsoCode: this.state.fromEndIsoCode,
                fromEndName: this.state.fromEndName,
                fromEndNameTso: this.state.fromEndNameTso,
                toEndIsoCode: this.state.toEndIsoCode,
                toEndName: this.state.toEndName,
                toEndNameTso: this.state.toEndNameTso
            };
        console.log('boundaryExtensions => ' + JSON.stringify(boundaryExtensions));

        // step 5
        if(this.state.id === '_add'){
            boundaryExtensions.boundaryExtensionsId=''
            BoundaryExtensionsService.createBoundaryExtensions(boundaryExtensions).then(res =>{
                this.props.history.push('/boundaryExtensionss');
            });
        }else{
            BoundaryExtensionsService.updateBoundaryExtensions(boundaryExtensions).then( res => {
                this.props.history.push('/boundaryExtensionss');
            });
        }
    }
    
    changeboundaryPointHandler= (event) => {
        this.setState({boundaryPoint: event.target.value});
    }
    changefromEndIsoCodeHandler= (event) => {
        this.setState({fromEndIsoCode: event.target.value});
    }
    changefromEndNameHandler= (event) => {
        this.setState({fromEndName: event.target.value});
    }
    changefromEndNameTsoHandler= (event) => {
        this.setState({fromEndNameTso: event.target.value});
    }
    changetoEndIsoCodeHandler= (event) => {
        this.setState({toEndIsoCode: event.target.value});
    }
    changetoEndNameHandler= (event) => {
        this.setState({toEndName: event.target.value});
    }
    changetoEndNameTsoHandler= (event) => {
        this.setState({toEndNameTso: event.target.value});
    }

    cancel(){
        this.props.history.push('/boundaryExtensionss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add BoundaryExtensions</h3>
        }else{
            return <h3 className="text-center">Update BoundaryExtensions</h3>
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
                                            <label> boundaryPoint: </label>
                                            #formFields( $attribute, 'create')
                                            <label> fromEndIsoCode: </label>
                                            #formFields( $attribute, 'create')
                                            <label> fromEndName: </label>
                                            #formFields( $attribute, 'create')
                                            <label> fromEndNameTso: </label>
                                            #formFields( $attribute, 'create')
                                            <label> toEndIsoCode: </label>
                                            #formFields( $attribute, 'create')
                                            <label> toEndName: </label>
                                            #formFields( $attribute, 'create')
                                            <label> toEndNameTso: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateBoundaryExtensions}>Save</button>
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

export default CreateBoundaryExtensionsComponent
