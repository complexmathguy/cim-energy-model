import React, { Component } from 'react'
import TransformerEndService from '../services/TransformerEndService';

class CreateTransformerEndComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                endNumber: '',
                grounded: '',
                rground: '',
                xground: ''
        }
        this.changeendNumberHandler = this.changeendNumberHandler.bind(this);
        this.changegroundedHandler = this.changegroundedHandler.bind(this);
        this.changergroundHandler = this.changergroundHandler.bind(this);
        this.changexgroundHandler = this.changexgroundHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            TransformerEndService.getTransformerEndById(this.state.id).then( (res) =>{
                let transformerEnd = res.data;
                this.setState({
                    endNumber: transformerEnd.endNumber,
                    grounded: transformerEnd.grounded,
                    rground: transformerEnd.rground,
                    xground: transformerEnd.xground
                });
            });
        }        
    }
    saveOrUpdateTransformerEnd = (e) => {
        e.preventDefault();
        let transformerEnd = {
                transformerEndId: this.state.id,
                endNumber: this.state.endNumber,
                grounded: this.state.grounded,
                rground: this.state.rground,
                xground: this.state.xground
            };
        console.log('transformerEnd => ' + JSON.stringify(transformerEnd));

        // step 5
        if(this.state.id === '_add'){
            transformerEnd.transformerEndId=''
            TransformerEndService.createTransformerEnd(transformerEnd).then(res =>{
                this.props.history.push('/transformerEnds');
            });
        }else{
            TransformerEndService.updateTransformerEnd(transformerEnd).then( res => {
                this.props.history.push('/transformerEnds');
            });
        }
    }
    
    changeendNumberHandler= (event) => {
        this.setState({endNumber: event.target.value});
    }
    changegroundedHandler= (event) => {
        this.setState({grounded: event.target.value});
    }
    changergroundHandler= (event) => {
        this.setState({rground: event.target.value});
    }
    changexgroundHandler= (event) => {
        this.setState({xground: event.target.value});
    }

    cancel(){
        this.props.history.push('/transformerEnds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TransformerEnd</h3>
        }else{
            return <h3 className="text-center">Update TransformerEnd</h3>
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
                                            <label> endNumber: </label>
                                            #formFields( $attribute, 'create')
                                            <label> grounded: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rground: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xground: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTransformerEnd}>Save</button>
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

export default CreateTransformerEndComponent
